package _05_Search_in_BST;

/**
 * @author cheng
 *         2018/5/11 16:17
 */
public class BST<E extends Comparable<E>> {

    private Node root;

    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    /**
     * 向二分搜索树中添加新的元素 e
     *
     * @param e
     */
    public void add(E e) {
        root = add(root, e);
    }

    /**
     * 向以 node 为根的二分搜索树中插入元素 e，递归算法
     * 返回插入新节点后二分搜索树的根
     *
     * @param node
     * @param e
     * @return
     */
    private Node add(Node node, E e) {

        if (node == null) {
            size++;
            return new Node(e);
        }

        int cmp = e.compareTo(node.e);
        if (cmp < 0) {
            node.left = add(node.left, e);
        } else if (cmp > 0) {
            node.right = add(node.right, e);
        }

        return node;
    }

    /**
     * 查询二分搜索树中是否包含元素 e
     *
     * @param e
     * @return
     */
    public boolean contains(E e) {
        return contains(root, e);
    }

    public boolean contains(Node node, E e) {

        if (node == null) {
            return false;
        }

        int cmp = e.compareTo(node.e);
        if (cmp == 0) {
            return true;
        } else if (cmp > 0) {
            return contains(node.right, e);
        } else {
            return contains(node.left, e);
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private class Node {
        private E e;
        private Node left, right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    public static void main(String[] args) {

        BST<Integer> bst = new BST<>();
        for (int i = 0; i < 5; i++) {
            bst.add(i);
        }

        System.out.println(bst.contains(2));
        System.out.println(bst.contains(5));
    }
}
