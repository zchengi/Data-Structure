package _01_Array_Basics;

/**
 * Java 数组的使用
 *
 * @author cheng
 *         2018/5/8 18:15
 */
public class Main {
    public static void main(String[] args) {

        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        int[] scores = new int[]{100, 50, 0};
        for (int score : scores) {
            System.out.println(score);
        }

        scores[0] = 99;
        for (int score : scores) {
            System.out.println(score);
        }
    }
}
