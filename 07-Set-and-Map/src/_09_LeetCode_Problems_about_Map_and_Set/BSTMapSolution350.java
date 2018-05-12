package _09_LeetCode_Problems_about_Map_and_Set;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * LeetCode 349. Intersection of Two Arrays II
 *
 * @author cheng
 *         2018/5/12 18:45
 */
public class BSTMapSolution350 {

    private interface Map<K, V> {

        void add(K key, V value);

        V get(K key);

        void set(K key, V value);

        V remove(K key);

        boolean contains(K key);

        int getSize();

        boolean isEmpty();
    }

    private class BSTMap<K extends Comparable<K>, V> implements Map<K, V> {

        private Node root;

        private int size;

        public BSTMap() {
            root = null;
            size = 0;
        }

        /**
         * 向二分搜索树中添加新的元素(key, value)
         *
         * @param key
         * @param value
         */
        @Override
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

            return node;
        }

        @Override
        public V get(K key) {
            Node node = getNode(root, key);
            return node == null ? null : node.value;
        }

        @Override
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
        @Override
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

        @Override
        public boolean contains(K key) {
            return getNode(root, key) != null;
        }

        @Override
        public int getSize() {
            return size;
        }

        @Override
        public boolean isEmpty() {
            return size == 0;
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

        private class Node {

            private K key;
            private V value;
            private Node left, right;

            public Node(K key, V value) {
                this.key = key;
                this.value = value;
                left = null;
                right = null;
            }
        }
    }

    public int[] intersect(int[] nums1, int[] nums2) {

        BSTMap<Integer, Integer> map = new BSTMap<>();
        for (int num : nums1) {
            if (!map.contains(num)) {
                map.add(num, 1);
            } else {
                map.add(num, map.get(num) + 1);
            }
        }

        ArrayList<Integer> res = new ArrayList<>();
        for (int num : nums2) {
            if (map.contains(num)) {
                res.add(num);
                map.add(num, map.get(num) - 1);
                if (map.get(num) == 0) {
                    map.remove(num);
                }
            }
        }

        int[] ret = new int[res.size()];
        for (int i = 0; i < res.size(); i++)
            ret[i] = res.get(i);

        return ret;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        System.out.println(Arrays.toString(new BSTMapSolution350().intersect(nums1, nums2)));
    }
}
