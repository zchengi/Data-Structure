package _04_TreeSet_and_Set_Probleams_in_LeetCode;

import java.util.TreeSet;

/**
 * LeetCode 804. Unique Morse Code Words
 *
 * @author cheng
 *         2018/5/12 15:45
 */
public class Solution {
    public int uniqueMorseRepresentations(String[] words) {

        String[] codes = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        TreeSet<String> bst = new TreeSet<>();

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
