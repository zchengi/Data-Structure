package _08_Trie_Using_HashMap_and_Array;

import java.util.HashMap;

/**
 * 使用 HashMap 实现的 Trie
 *
 * @author cheng
 *         2018/7/23 20:51
 */
public class Trie2 {

    private Node root;

    private int size;

    public Trie2() {
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
     * 获取 Trie 中存储的单词数量
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    private class Node {

        private boolean isWord;
        private HashMap<Character, Node> next;

        public Node() {
            this(false);
        }

        public Node(boolean isWord) {
            this.isWord = isWord;
            next = new HashMap<>();
        }
    }
}
