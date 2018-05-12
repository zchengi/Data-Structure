package _09_LeetCode_Problems_about_Map_and_Set;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeMap;

/**
 * LeetCode 349. Intersection of Two Arrays II
 *
 * @author cheng
 *         2018/5/12 18:26
 */
public class Solution350 {
    public int[] intersect(int[] nums1, int[] nums2) {

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums1) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
        }

        ArrayList<Integer> res = new ArrayList<>();
        for (int num : nums2) {
            if (map.containsKey(num)) {
                res.add(num);
                map.put(num, map.get(num) - 1);
                if (map.get(num) == 0) {
                    map.remove(num);
                }
            }
        }

        int[] ret = new int[res.size()];
        for (int i = 0; i < res.size(); i++)
            ret[i] = res.get(i);

        return ret;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        System.out.println(Arrays.toString(new Solution350().intersect(nums1, nums2)));
    }
}
