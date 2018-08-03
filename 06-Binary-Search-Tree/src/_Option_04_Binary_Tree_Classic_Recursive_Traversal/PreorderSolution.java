package _Option_04_Binary_Tree_Classic_Recursive_Traversal;


import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树前序遍历：递归实现
 * <p>
 * 时间复杂度: O(n)
 * 空间复杂度: O(1)
 *
 * @author cheng
 *         2018/8/3 15:10
 */
public class PreorderSolution {
    public List<Integer> preorderTraversal(TreeNode root) {

        ArrayList<Integer> res = new ArrayList<>();

        preorderTraversal(root, res);
        return res;
    }

    private void preorderTraversal(TreeNode node, ArrayList<Integer> res) {

        if (node == null) {
            return;
        }

        res.add(node.val);
        preorderTraversal(node.left, res);
        preorderTraversal(node.right, res);
    }

    public static void main(String[] args) {

        TreeNode left = new TreeNode(2);
        left.left = new TreeNode(1);
        left.right = new TreeNode(3);

        TreeNode right = new TreeNode(6);
        right.left = new TreeNode(5);
        right.right = new TreeNode(7);

        TreeNode root = new TreeNode(4);
        root.left = left;
        root.right = right;

        System.out.println(new PreorderSolution().preorderTraversal(root));
    }
}
