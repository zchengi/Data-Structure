package _02_Binary_Search_Tree_Basics;

/**
 * @author cheng
 *         2018/5/11 12:12
 */
public class BST<E extends Comparable<E>> {

    private Node root;

    private int size;

    public BST() {
        root = null;
        size = 0;
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
