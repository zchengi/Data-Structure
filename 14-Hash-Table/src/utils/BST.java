package utils;

import java.util.ArrayList;

/**
 * @author cheng
 *         2018/5/11 21:40
 */
public class BST<K extends Comparable<K>, V> {

    private Node root;
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    /**
     * 向二分搜索树中添加新的元素 e
     *
     * @param key
     * @param value
     */
    public void add(K key, V value) {
        root = add(root, key, value);
    }

    /**
     * 向以 node 为根的二分搜索树中插入元素 e，递归算法
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
        }

        return node;
    }

    public V get(K key) {
        Node node = getNode(root, key);
        return node == null ? null : node.value;
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

    public void set(K key, V newValue) {
        Node node = getNode(root, key);
        if (node == null)
            throw new IllegalArgumentException(key + " doesn't exist!");

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
            } else if (node.right == null) {
                // 待删除节点右子树为空的情况
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            } else {
                // 待删除节点左右子树均不为空的情况

                // 找到比待删除节点大的最小节点, 即待删除节点右子树的最小节点
                // 用这个节点顶替待删除节点的位置
                Node successor = minimum(node.right);
                // successor.right = removeMin(node.right);
                successor.right = remove(node.right, successor.key);
                successor.left = node.left;

                node.left = node.right = null;

                return successor;
            }
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
     * 查询二分搜索树中是否包含元素 e
     *
     * @param key
     * @return
     */
    public boolean contains(K key) {
        return getNode(root,key)!= null;
    }

    private class Node {
        public K key;
        public V value;
        private Node left, right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            left = null;
            right = null;
        }
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {

        System.out.println("Pride and Prejudice");

        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile("13-Red-Black-Tree/src/txt/pride-and-prejudice.txt", words)) {
            System.out.println("Total words: " + words.size());

            BST<String, Integer> BST = new BST<>();
            for (String word : words) {
                if (BST.contains(word)) {
                    BST.set(word, BST.get(word) + 1);
                } else {
                    BST.add(word, 1);
                }
            }

            System.out.println("Total different words: " + BST.getSize());
            System.out.println("Frequency of PRIDE: " + BST.get("pride"));
            System.out.println("Frequency of PREJUDICE: " + BST.get("prejudice"));
        }
    }
}
