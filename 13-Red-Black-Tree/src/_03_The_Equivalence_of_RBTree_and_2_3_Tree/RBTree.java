package _03_The_Equivalence_of_RBTree_and_2_3_Tree;

/**
 * @author cheng
 *         2018/6/24 14:21
 */
public class RBTree<K extends Comparable<K>, V> {

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private Node root;
    private int size;

    public RBTree() {
        root = null;
        size = 0;
    }

    private class Node {
        private K key;
        private V value;
        private Node left, right;
        private boolean color;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            left = null;
            right = null;
            color = RED;
        }

        /**
         * 判断节点的颜色
         *
         * @param node
         * @return
         */
        private boolean isRed(Node node) {

            if (node == null) {
                return BLACK;
            }
            return node.color;
        }

        public int getSize() {
            return size;
        }

        public boolean isEmpty() {
            return size == 0;
        }
    }
}
