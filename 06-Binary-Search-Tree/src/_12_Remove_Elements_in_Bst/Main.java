package _12_Remove_Elements_in_Bst;

/**
 * @author cheng
 *         2018/5/11 21:52
 */
public class Main {
    public static void main(String[] args) {


        BST<Integer> bst = new BST<>();
        int[] nums = {5, 3, 10, 8, 7, 9, 12, 13, 11, 2, 4, 1};
        for (int num : nums) {
            bst.add(num);
        }

        System.out.println(bst);

        bst.remove(10);
        System.out.println(bst);
    }
}
