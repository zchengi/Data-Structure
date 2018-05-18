package _06_LR_and_RL;

import utils.FileOperation;

import java.util.ArrayList;

/**
 * @author cheng
 *         2018/5/18 16:15
 */
public class AVLTree<K extends Comparable<K>, V> {

    private Node root;

    private int size;

    public AVLTree() {
        root = null;
        size = 0;
    }

    /**
     * 向二分搜索树中添加新的元素(key, value)
     *
     * @param key
     * @param value
     */
    public void add(K key, V value) {
        root = add(root, key, value);
    }

    /**
     * 向以node为根的二分搜索树中插入元素(key, value)，递归算法
     * 返回插入新节点后二分搜索树的根
     *
     * @param node
     * @param key
     * @param value
     * @return
     */
    private Node add(Node node, K key, V value) {

        if (node == null) {
            size++;
            return new Node(key, value);
        }

        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = add(node.left, key, value);
        } else if (cmp > 0) {
            node.right = add(node.right, key, value);
        } else {
            // key.compareTo(node.key) == 0
            node.value = value;
        }

        // 更新 height
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));

        // 计算平衡因子
        int balanceFactor = getBalanceFactor(node);
        /*if (Math.abs(balanceFactor) > 1) {
            System.out.println("unbalanced: " + balanceFactor);
        }*/

        // 平衡维护

        // LL
        if (balanceFactor > 1 && getBalanceFactor(node.left) >= 0) {
            return rightRotate(node);
        }

        // RR
        if (balanceFactor < -1 && getBalanceFactor(node.right) <= 0) {
            return leftRotate(node);
        }

        // LR
        if (balanceFactor > 1 && getBalanceFactor(node.left) < 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // RL
        if (balanceFactor < -1 && getBalanceFactor(node.right) > 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    public V get(K key) {
        Node node = getNode(root, key);
        return node == null ? null : node.value;
    }

    public void set(K key, V newValue) {

        Node node = getNode(root, key);

        if (node == null) {
            throw new IllegalArgumentException(key + " doesn't exist!");
        }

        node.value = newValue;
    }


    /**
     * 从二分搜索树中删除键为key的节点
     *
     * @param key
     * @return
     */
    public V remove(K key) {

        Node node = getNode(root, key);
        if (node != null) {
            root = remove(root, key);
            return node.value;
        }
        return null;
    }

    private Node remove(Node node, K key) {

        if (node == null) {
            return null;
        }

        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = remove(node.left, key);
            return node;
        } else if (cmp > 0) {
            node.right = remove(node.right, key);
            return node;
        } else {

            // 待删除节点左子树为空的情况
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }

            // 待删除节点右子树为空的情况
            if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }

            // 待删除节点左右子树均不为空的情况

            // 找到比待删除节点大的最小节点, 即待删除节点右子树的最小节点
            // 用这个节点顶替待删除节点的位置
            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;

            node.left = node.right = null;

            return successor;
        }
    }

    /**
     * 返回以node为根的二分搜索树的最小值所在的节点
     *
     * @param node
     * @return
     */
    private Node minimum(Node node) {
        if (node.left == null) {
            return node;
        }
        return minimum(node.left);
    }

    /**
     * 删除掉以node为根的二分搜索树中的最小节点
     * 返回删除节点后新的二分搜索树的根
     *
     * @param node
     * @return
     */
    private Node removeMin(Node node) {

        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }

    /**
     * 返回以 node 为根节点的二分搜索树中，key 所在的节点
     *
     * @param node
     * @param key
     * @return
     */
    private Node getNode(Node node, K key) {

        if (node == null) {
            return null;
        }

        int cmp = key.compareTo(node.key);
        if (cmp == 0) {
            return node;
        } else if (cmp < 0) {
            return getNode(node.left, key);
        } else {
            // cmp > 0
            return getNode(node.right, key);
        }
    }

    /**
     * 对节点y进行向右旋转操作，返回旋转后的新的根节点x
     * //        y                              x
     * //       / \                           /   \
     * //      x   T4     向右旋转 (y)        z     y
     * //     / \       - - - - - - - ->    / \   / \
     * //    z   T3                       T1  T2 T3 T4
     * //   / \
     * // T1   T2
     *
     * @param y
     * @return
     */
    private Node rightRotate(Node y) {

        Node x = y.left;

        // 向右旋转过程
        y.left = x.right;
        x.right = y;

        // 更新 height
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;

        return x;
    }

    /**
     * 对节点y进行向左旋转操作，返回旋转后的新的根节点x
     * //    y                             x
     * //  /  \                          /   \
     * // T1   x      向左旋转 (y)       y     z
     * //     / \   - - - - - - - ->   / \   / \
     * //   T2   z                    T1 T2 T3 T4
     * //       / \
     * //      T3 T4
     *
     * @param y
     * @return
     */
    private Node leftRotate(Node y) {

        Node x = y.right;

        // 向左旋转过程
        y.right = x.left;
        x.left = y;

        // 更新 height
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;

        return x;
    }


    /**
     * 判断该二叉树是否是一颗二分搜索树
     *
     * @return
     */
    public boolean isBST() {

        ArrayList<K> keys = new ArrayList<>();
        inOrder(root, keys);
        for (int i = 1; i < keys.size(); i++) {
            if (keys.get(i - 1).compareTo(keys.get(i)) > 0) {
                return false;
            }
        }
        return true;
    }

    private void inOrder(Node node, ArrayList<K> keys) {

        if (node == null) {
            return;
        }

        inOrder(node.left, keys);
        keys.add(node.key);
        inOrder(node.right, keys);
    }

    /**
     * 判断该二叉树是否是一颗平衡二叉树
     *
     * @return
     */
    public boolean isBalanced() {
        return isBalanced(root);
    }

    /**
     * 判断以 node 为根的二叉树是否是一颗平衡二叉树，递归算法
     *
     * @param node
     * @return
     */
    private boolean isBalanced(Node node) {

        if (node == null) {
            return true;
        }

        int balanceFactor = getBalanceFactor(node);
        if (Math.abs(balanceFactor) > 1) {
            return false;
        }

        return isBalanced(node.left) && isBalanced(node.right);
    }

    /**
     * 获得节点 node 的高度
     *
     * @param node
     * @return
     */
    private int getHeight(Node node) {
        return node == null ? 0 : node.height;
    }

    /**
     * 获得节点 node 的平衡因子
     *
     * @param node
     * @return
     */
    private int getBalanceFactor(Node node) {
        return node == null ? 0 : getHeight(node.left) - getHeight(node.right);
    }

    public boolean contains(K key) {
        return getNode(root, key) != null;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private class Node {

        private K key;
        private V value;
        private Node left, right;
        private int height;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            left = null;
            right = null;
            height = 1;
        }
    }

    public static void main(String[] args) {

        System.out.println("Pride and Prejudice");

        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile("12-AVL-Tree/src/txt/pride-and-prejudice.txt", words)) {
            System.out.println("Total words: " + words.size());

            AVLTree<String, Integer> map = new AVLTree<>();
            for (String word : words) {
                if (map.contains(word)) {
                    map.set(word, map.get(word) + 1);
                } else {
                    map.add(word, 1);
                }
            }

            System.out.println("Total different words: " + map.getSize());
            System.out.println("Frequency of PRIDE: " + map.get("pride"));
            System.out.println("Frequency of PREJUDICE: " + map.get("prejudice"));
            System.out.println(map.isBST());
            System.out.println(map.isBalanced());
        }
    }
}
