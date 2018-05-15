package _06_Update_Single_Element_in_Segment_Tree;

/**
 * LeetCode 307. Range Sum Query - Mutable
 *
 * @author cheng
 *         2018/5/15 14:13
 */
public class NumArray307 {

    private SegmentTree<Integer> segmentTree;

    public NumArray307(int[] nums) {

        if (nums.length > 0) {
            Integer[] data = new Integer[nums.length];
            for (int i = 0; i < nums.length; i++) {
                data[i] = nums[i];
            }
            segmentTree = new SegmentTree<>(data, (a, b) -> a + b);
        }
    }

    public void update(int index, int val) {

        if (segmentTree == null) {
            throw new IllegalArgumentException("Segment Tree is null");
        }

        segmentTree.set(index, val);
    }

    public int sumRange(int i, int j) {

        if (segmentTree == null) {
            throw new IllegalArgumentException("Segment Tree is null");
        }

        return segmentTree.query(i, j);
    }

    public static void main(String[] args) {

        int[] nums = {1, 3, 5};
        NumArray307 numArray = new NumArray307(nums);
        System.out.println(numArray.sumRange(0, 2));
        numArray.update(1, 2);
        System.out.println(numArray.sumRange(0, 2));
    }
}
