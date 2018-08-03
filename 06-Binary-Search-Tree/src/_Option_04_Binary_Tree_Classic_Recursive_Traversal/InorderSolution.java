package _Option_04_Binary_Tree_Classic_Recursive_Traversal;


import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树中序遍历：递归实现
 * <p>
 * 时间复杂度: O(n)
 * 空间复杂度: O(1)
 *
 * @author cheng
 *         2018/8/3 14:47
 */
public class InorderSolution {
    public List<Integer> inorderTraversal(TreeNode root) {

        ArrayList<Integer> res = new ArrayList<>();

        inorderTraversal(root, res);
        return res;
    }

    private void inorderTraversal(TreeNode node, ArrayList<Integer> res) {

        if (node == null) {
            return;
        }

        inorderTraversal(node.left, res);
        res.add(node.val);
        inorderTraversal(node.right, res);
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

        System.out.println(new InorderSolution().inorderTraversal(root));
    }
}
