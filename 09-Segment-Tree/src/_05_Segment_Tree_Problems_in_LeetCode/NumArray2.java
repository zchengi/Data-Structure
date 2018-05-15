package _05_Segment_Tree_Problems_in_LeetCode;


/**
 * LeetCode 303. Range Sum Query - Immutable
 *
 * @author cheng
 *         2018/5/15 13:51
 */
public class NumArray2 {

    /**
     * sum[i] 存储前 i 个元素的和
     * sum[i] 存储 nums[0...i-1] 的和
     * sum(i, j) = sum[j + 1] - sum[i]
     */
    private int[] sum;

    public NumArray2(int[] nums) {

        sum = new int[nums.length + 1];
        sum[0] = 0;
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
    }

    public int sumRange(int i, int j) {
        return sum[j + 1] - sum[i];
    }

    public static void main(String[] args) {

        int[] nums = {-2, 0, 3, -5, 2, -1};
        NumArray2 numArray = new NumArray2(nums);
        System.out.println(numArray.sumRange(0, 2));
        System.out.println(numArray.sumRange(2, 5));
        System.out.println(numArray.sumRange(0, 5));
    }
}
