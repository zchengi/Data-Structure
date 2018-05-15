package _05_Segment_Tree_Problems_in_LeetCode;

/**
 * LeetCode 307. Range Sum Query - Mutable
 * <p>
 * 超时
 * <p>
 * update 操作时间复杂度为：O(n)
 *
 * @author cheng
 *         2018/5/15 14:00
 */
public class NumArray307 {

    private int[] data;
    private int[] sum;

    public NumArray307(int[] nums) {

        data = new int[nums.length];
        System.arraycopy(nums, 0, data, 0, nums.length);

        sum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
    }

    public void update(int index, int val) {
        data[index] = val;
        for (int i = index + 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + data[i - 1];
        }
    }

    public int sumRange(int i, int j) {
        return sum[j + 1] - sum[i];
    }

    public static void main(String[] args) {

        int[] nums = {1, 3, 5};
        NumArray307 numArray = new NumArray307(nums);
        System.out.println(numArray.sumRange(0, 2));
        numArray.update(1, 2);
        System.out.println(numArray.sumRange(0, 2));
    }
}
