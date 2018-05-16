package _03_Searching_in_Trie;

import java.util.TreeMap;

/**
 * @author cheng
 *         2018/5/16 18:39
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
