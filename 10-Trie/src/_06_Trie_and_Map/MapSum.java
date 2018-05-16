package _06_Trie_and_Map;

import java.util.TreeMap;

/**
 * LeetCode 677. Map Sum Pairs
 *
 * @author cheng
 *         2018/5/17 1:17
 */
public class MapSum {

    private Node root;

    public MapSum() {
        root = new Node();
    }

    public void insert(String key, int val) {

        Node cur = root;
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            if (cur.next.get(c) == null) {
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }

        cur.value = val;
    }

    public int sum(String prefix) {

        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (cur.next.get(c) == null) {
                return 0;
            }
            cur = cur.next.get(c);
        }

        return sum(cur);
    }

    private int sum(Node node) {

        int res = node.value;

        for (char c : node.next.keySet()) {
            res += sum(node.next.get(c));
        }

        return res;
    }

    private class Node {

        private int value;
        private TreeMap<Character, Node> next;

        public Node(int value) {
            this.value = value;
            next = new TreeMap<>();
        }

        public Node() {
            this(0);
        }
    }

    public static void main(String[] args) {

        MapSum mapSum = new MapSum();
        mapSum.insert("apple", 3);
        System.out.println(mapSum.sum("ap"));
    }
}
