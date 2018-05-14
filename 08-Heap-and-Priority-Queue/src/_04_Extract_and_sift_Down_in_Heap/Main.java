package _04_Extract_and_sift_Down_in_Heap;

import java.util.Random;

/**
 * @author cheng
 *         2018/5/14 15:59
 */
public class Main {
    public static void main(String[] args) {

        int n = 1000000;

        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            maxHeap.add(random.nextInt(Integer.MAX_VALUE));
        }

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = maxHeap.extractMax();
        }

        for (int i = 1; i < n; i++) {
            if (arr[i - 1] < arr[i]) {
                System.out.println("Error");
                return;
            }
        }
        System.out.println("Test MaxHeap completed.");
    }
}