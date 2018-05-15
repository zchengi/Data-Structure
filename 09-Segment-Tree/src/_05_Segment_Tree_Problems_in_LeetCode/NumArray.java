package _05_Segment_Tree_Problems_in_LeetCode;

import java.util.NoSuchElementException;

/**
 * LeetCode 303. Range Sum Query - Immutable
 *
 * @author cheng
 *         2018/5/15 13:36
 */
public class NumArray {

    private SegmentTree<Integer> segmentTree;

    public NumArray(int[] nums) {

        if (nums.length > 0) {
            Integer[] data = new Integer[nums.length];
            for (int i = 0; i < nums.length; i++) {
                data[i] = nums[i];
            }
            segmentTree = new SegmentTree<>(data, (a, b) -> a + b);
        }
    }

    public int sumRange(int i, int j) {

        if (segmentTree == null) {
            throw new NoSuchElementException("Segment Tree is null.");
        }

        return segmentTree.query(i, j);
    }

    public static void main(String[] args) {

        int[] nums = {-2, 0, 3, -5, 2, -1};
        NumArray numArray = new NumArray(nums);
        System.out.println(numArray.sumRange(0, 2));
        System.out.println(numArray.sumRange(2, 5));
        System.out.println(numArray.sumRange(0, 5));
    }
}
