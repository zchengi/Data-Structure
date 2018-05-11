package _03_Add_Elements_in_BST;

/**
 * @author cheng
 *         2018/5/11 15:12
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

        if (root == null) {
            root = new Node(e);
            size++;
        } else {
            add(root, e);
        }
    }

    /**
     * 向以 node 为根的二分搜索树中插入元素 e，递归算法
     *
     * @param node
     * @param e
     */
    private void add(Node node, E e) {

        int cmp = e.compareTo(node.e);
        if (e.equals(node.e)) {
            return;
        } else if (cmp < 0 && node.left == null) {
            node.left = new Node(e);
            size++;
            return;
        } else if (cmp > 0 && node.right == null) {
            node.right = new Node(e);
            size++;
            return;
        }

        if (cmp < 0) {
            add(node.left, e);
        } else {
            add(node.right, e);
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
}
