package _04_Prefix_in_Trie;

import java.util.TreeMap;

/**
 * @author cheng
 *         2018/5/16 18:54
 */
public class Trie {

    private Node root;

    private int size;

    public Trie() {
        root = new Node();
        size = 0;
    }

    /**
     * 向 Trie 中添加一个新的单词 word
     *
     * @param word
     */
    public void add(String word) {

        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null) {
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }

        if (!cur.isWord) {
            cur.isWord = true;
            size++;
        }
    }

    /**
     * 查询单词 word 是否在 Trie 中
     *
     * @param word
     * @return
     */
    public boolean contains(String word) {

        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null) {
                return false;
            }
            cur = cur.next.get(c);
        }
        return cur.isWord;
    }

    /**
     * 查询是否在 Trie 中有单词以 prefix 为前缀
     *
     * @param prefix
     * @return
     */
    public boolean isPrefix(String prefix) {

        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (cur.next.get(c) == null) {
                return false;
            }

            cur = cur.next.get(c);
        }
        return true;
    }

    public int getSize() {
        return size;
    }

    private class Node {

        private boolean isWord;
        private TreeMap<Character, Node> next;

        public Node(boolean isWord) {
            this.isWord = isWord;
            next = new TreeMap<>();
        }

        public Node() {
            this(false);
        }
    }
}
