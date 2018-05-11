package _10_Level_Traverse_in_BST;


/**
 * @author cheng
 *         2018/5/11 20:31
 */
public class Main {
    public static void main(String[] args) {

        BST<Integer> bst = new BST<>();
        int[] nums = {5, 3, 6, 8, 2, 4};
        for (int num : nums) {
            bst.add(num);
        }

        bst.levelOrder();
    }
}
