package _01_Hash_Table_Basics;

/**
 * LeetCode 387. First Unique Character in a String
 *
 * @author cheng
 *         2018/8/2 12:08
 */
public class Solution {
    public int firstUniqChar(String s) {

        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        String s = "leetcode";
        System.out.println(new Solution().firstUniqChar(s));

        s = "loveleetcode";
        System.out.println(new Solution().firstUniqChar(s));
    }
}
