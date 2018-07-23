package _08_Trie_Using_HashMap_and_Array;

/**
 * 使用 数组 实现的 Trie
 * <p>
 * 固定单词中只能出现26个小写字母
 *
 * @author cheng
 *         2018/7/23 20:53
 */
public class Trie3 {

    private Node root;

    private int size;

    public Trie3() {
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
            if (cur.next[c - 'a'] == null) {
                cur.next[c - 'a'] = new Node();
            }
            cur = cur.next[c - 'a'];
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
            if (cur.next[c - 'a'] == null) {
                return false;
            }
            cur = cur.next[c - 'a'];
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
        private Node[] next;

        public Node() {
            this(false);
        }

        public Node(boolean isWord) {
            this.isWord = isWord;
            next = new Node[26];
        }
    }
}
