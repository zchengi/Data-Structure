package _02_Trie_Basics;

import java.util.TreeMap;

/**
 * @author cheng
 *         2018/5/16 16:13
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
