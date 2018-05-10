package _03_Recursion_Basics;

/**
 * @author cheng
 *         2018/5/10 15:56
 */

public class Sum {

    public static int sum(int[] arr) {
        return sum(arr, 0);
    }

    /**
     * 计算 arr[l...n) 这个区间内所有数字的和
     *
     * @param arr
     * @param l
     * @return
     */
    private static int sum(int[] arr, int l) {
        if (l == arr.length) {
            return 0;
        }
        return arr[l] + sum(arr, l + 1);
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4, 5};
        System.out.println(sum(nums));
    }
}
