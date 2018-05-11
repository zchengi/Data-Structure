package _04_Improved_Add_Elements_in_BST;

/**
 * @author cheng
 *         2018/5/11 15:32
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
