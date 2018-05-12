package _09_LeetCode_Problems_about_Map_and_Set;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

/**
 * LeetCode 349. Intersection of Two Arrays
 *
 * @author cheng
 *         2018/5/12 18:26
 */
public class Solution349 {
    public int[] intersection(int[] nums1, int[] nums2) {

        ArrayList<Integer> list = new ArrayList<>();
        TreeSet<Integer> set = new TreeSet<>();
        for (int num : nums1) {
            set.add(num);
        }

        for (int num : nums2) {
            if (set.contains(num)) {
                list.add(num);
                set.remove(num);
            }
        }

        int[] res = new int[list.size()];
        int index = 0;
        for (int num : list) {
            res[index++] = num;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        System.out.println(Arrays.toString(new Solution349().intersection(nums1, nums2)));
    }
}
