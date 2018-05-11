package _06_PreOrder_and_InOrder_and_PostOrder_Traverse_in_BST;

/**
 * @author cheng
 *         2018/5/11 16:32
 */
public class Main {
    public static void main(String[] args) {

        BST<Integer> bst = new BST<>();
        int[] nums = {5, 3, 6, 8, 2, 4};
        for (int num : nums) {
            bst.add(num);
        }

        bst.preOrder();
        System.out.println();
        bst.preOrderNR();
        System.out.println();

        bst.inOrder();
        System.out.println();
        bst.postOrder();
        System.out.println();

        System.out.println(bst);
    }
}
