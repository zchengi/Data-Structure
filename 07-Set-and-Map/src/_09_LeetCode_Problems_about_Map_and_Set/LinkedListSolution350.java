package _09_LeetCode_Problems_about_Map_and_Set;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * LeetCode 349. Intersection of Two Arrays II
 *
 * @author cheng
 *         2018/5/12 18:48
 */
public class LinkedListSolution350 {

    private interface Map<K, V> {

        void add(K key, V value);

        V get(K key);

        void set(K key, V value);

        V remove(K key);

        boolean contains(K key);

        int getSize();

        boolean isEmpty();
    }

    private class LinkedListMap<K, V> implements Map<K, V> {

        private Node dummyHead;

        private int size;

        public LinkedListMap() {
            dummyHead = new Node(null, null, null);
            size = 0;
        }

        @Override
        public void add(K key, V value) {

            Node node = getNode(key);
            if (node == null) {
                dummyHead.next = new Node(key, value, dummyHead.next);
                size++;
            } else {
                node.value = value;
            }
        }

        @Override
        public V get(K key) {
            Node node = getNode(key);
            return node == null ? null : node.value;
        }

        @Override
        public void set(K key, V newValue) {

            Node node = getNode(key);
            if (node == null) {
                throw new IllegalArgumentException(key + " doesn't exist!");
            }

            node.value = newValue;
        }

        @Override
        public V remove(K key) {

            if (isEmpty()) {
                throw new NoSuchElementException("Map is Empty!");
            }

            Node prev = dummyHead;
            while (prev.next != null) {
                if (prev.next.key.equals(key)) {
                    break;
                }
                prev = prev.next;
            }

            if (prev.next != null) {
                Node delNode = prev.next;
                prev.next = delNode.next;
                delNode.next = null;
                size--;
                return delNode.value;
            }

            return null;
        }

        @Override
        public boolean contains(K key) {
            return getNode(key) != null;
        }

        @Override
        public int getSize() {
            return size;
        }

        @Override
        public boolean isEmpty() {
            return size == 0;
        }

        private Node getNode(K key) {

            Node cur = dummyHead.next;
            while (cur != null) {
                if (cur.key.equals(key)) {
                    return cur;
                }
                cur = cur.next;
            }
            return null;
        }

        private class Node {

            private K key;
            private V value;
            private Node next;

            public Node(K key, V value, Node next) {
                this.key = key;
                this.value = value;
                this.next = next;
            }

            @Override
            public String toString() {
                return key.toString() + " : " + value.toString();
            }
        }
    }

    public int[] intersect(int[] nums1, int[] nums2) {

        LinkedListMap<Integer, Integer> map = new LinkedListMap<>();
        for (int num : nums1) {
            if (!map.contains(num))
                map.add(num, 1);
            else
                map.set(num, map.get(num) + 1);
        }

        ArrayList<Integer> res = new ArrayList<>();
        for (int num : nums2) {
            if (map.contains(num)) {
                res.add(num);
                map.set(num, map.get(num) - 1);
                if (map.get(num) == 0)
                    map.remove(num);
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
        System.out.println(Arrays.toString(new LinkedListSolution350().intersect(nums1, nums2)));
    }
}
