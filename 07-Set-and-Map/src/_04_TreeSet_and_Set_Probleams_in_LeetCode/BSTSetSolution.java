package _04_TreeSet_and_Set_Probleams_in_LeetCode;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Stack;

/**
 * @author cheng
 *         2018/5/12 15:52
 */
public class BSTSetSolution {

    private class BST<E extends Comparable<E>> {

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

        /**
         * 二分搜索树的前序遍历
         */
        public void preOrder() {
            preOrder(root);
        }

        /**
         * 前序遍历以 node 为根的二分搜索树，递归算法
         *
         * @param node
         */
        public void preOrder(Node node) {

            if (node == null) {
                return;
            }

            System.out.println(node.e);
            preOrder(node.left);
            preOrder(node.right);
        }

        /**
         * 二分搜索树的非递归前序遍历
         */
        public void preOrderNR() {

            if (root == null) {
                return;
            }

            Stack<Node> stack = new Stack<>();

            stack.push(root);
            while (!stack.isEmpty()) {

                Node cur = stack.pop();
                System.out.println(cur.e);

                if (cur.right != null) {
                    stack.push(cur.right);
                }
                if (cur.left != null) {
                    stack.push(cur.left);
                }
            }
        }

        /**
         * 二分搜索树的中序遍历
         */
        public void inOrder() {
            inOrder(root);
        }

        /**
         * 中序遍历以 node 为根的二分搜索树，递归算法
         *
         * @param node
         */
        public void inOrder(Node node) {

            if (node == null) {
                return;
            }

            inOrder(node.left);
            System.out.println(node.e);
            inOrder(node.right);
        }

        /**
         * 二分搜索树的后序遍历
         */
        public void postOrder() {
            postOrder(root);
        }

        /**
         * 后序遍历以 node 为根的二分搜索树，递归算法
         *
         * @param node
         */
        public void postOrder(Node node) {

            if (node == null) {
                return;
            }

            postOrder(node.left);
            postOrder(node.right);
            System.out.println(node.e);
        }

        /**
         * 二分搜索树的层序遍历
         */
        public void levelOrder() {

            if (root == null) {
                return;
            }

            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                Node cur = queue.remove();
                System.out.println(cur.e);

                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
        }

        /**
         * 寻找二分搜索树的最小元素
         *
         * @return
         */
        public E minimum() {

            if (size == 0) {
                throw new NoSuchElementException("BST is empty!");
            }
            return minimum(root).e;
        }

        /**
         * 返回以 node 为根的二分搜索树的最小值所在的节点
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
         * 寻找二分搜索树的最大元素
         *
         * @return
         */
        public E maximum() {

            if (size == 0) {
                throw new NoSuchElementException("BST is empty!");
            }
            return maximum(root).e;
        }

        /**
         * 返回以 node 为根的二分搜索树的最大值所在的节点
         *
         * @param node
         * @return
         */
        private Node maximum(Node node) {

            if (node.right == null) {
                return node;
            }
            return maximum(node.right);
        }

        /**
         * 从二分搜索树中删除最小值所在节点，返回最小值
         *
         * @return
         */
        public E removeMin() {

            E ret = minimum();

            root = removeMin(root);
            return ret;
        }

        /**
         * 删除以 node 为根的二分搜索树的最小节点
         * 返回删除最小节点后二分搜索树的根
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
         * 从二分搜索树中删除最大值所在节点，返回最大值
         *
         * @return
         */
        public E removeMax() {

            E ret = maximum();

            root = removeMax(root);
            return ret;
        }

        /**
         * 删除以 node 为根的二分搜索树的最大节点
         * 返回删除最大节点后二分搜索树的根
         *
         * @param node
         * @return
         */
        private Node removeMax(Node node) {

            if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }

            node.right = removeMax(node.right);
            return node;
        }

        /**
         * 从二分搜索树中删除元素为 e 的节点
         *
         * @param e
         */
        public void remove(E e) {
            root = remove(root, e);
        }

        /**
         * 删除以 node 为根的二分搜索树中值为 e 的节点，递归算法
         * 返回删除节点后新的二分搜索树的根
         *
         * @param node
         * @param e
         * @return
         */
        private Node remove(Node node, E e) {

            if (node == null) {
                return null;
            }

            int cmp = e.compareTo(node.e);
            if (cmp < 0) {
                node.left = remove(node.left, e);
                return node;
            } else if (cmp > 0) {
                node.right = remove(node.right, e);
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
                // 找到比待删除节点大的最小节点，即待删除节点右子树的最小节点
                // 用这个节点顶替待删除节点的位置
                Node successor = minimum(node.right);
                successor.right = removeMin(node.right);
                successor.left = node.left;

                node.left = node.right = null;

                return successor;
            }
        }

        public int size() {
            return size;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        @Override
        public String toString() {
            StringBuilder res = new StringBuilder();
            generateBSTString(root, 0, res);
            return res.toString();
        }

        /**
         * 生成以 node 为根节点，深度为 depth 的描述二叉树字符串
         *
         * @param node
         * @param depth
         * @param res
         */
        private void generateBSTString(Node node, int depth, StringBuilder res) {

            if (node == null) {
                res.append(generateDepthString(depth)).append("null\n");
                return;
            }
            res.append(generateDepthString(depth)).append(node.e).append("\n");
            generateBSTString(node.left, depth + 1, res);
            generateBSTString(node.right, depth + 1, res);
        }

        private String generateDepthString(int depth) {

            StringBuilder res = new StringBuilder();
            for (int i = 0; i < depth; i++) {
                res.append("--");
            }
            return res.toString();
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

    public int uniqueMorseRepresentations(String[] words) {

        String[] codes = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        BST<String> bst = new BST<>();

        for (String word : words) {
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                res.append(codes[word.charAt(i) - 'a']);
            }
            bst.add(res.toString());
        }

        return bst.size();
    }

    public static void main(String[] args) {

        String[] words = {"gin", "zen", "gig", "msg"};
        System.out.println(new Solution().uniqueMorseRepresentations(words));
    }

}
