package _05_Trie_and_Pattern_Match;

import java.util.TreeMap;

/**
 * LeetCode 211. Add and Search Word - Data structure design
 *
 * @author cheng
 *         2018/5/16 19:04
 */
public class WordDictionary {

    private Node root;

    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {

        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null) {
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }
        cur.isWord = true;
    }

    public boolean search(String word) {
        return match(root, word, 0);
    }

    private boolean match(Node node, String word, int index) {

        if (index == word.length()) {
            return node.isWord;
        }

        char c = word.charAt(index);
        if (c != '.') {
            if (node.next.get(c) == null) {
                return false;
            }
            return match(node.next.get(c), word, index + 1);
        } else {
            for (char nextChar : node.next.keySet()) {
                if (match(node.next.get(nextChar), word, index + 1)) {
                    return true;
                }
            }
            return false;
        }
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

    public static void main(String[] args) {

        String word = "zzz";
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord(word);
        System.out.println(wordDictionary.search(".zz"));
    }
}
