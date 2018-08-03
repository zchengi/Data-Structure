package _Option_04_Binary_Tree_Classic_Recursive_Traversal;


import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树后序遍历：递归实现
 * <p>
 * 时间复杂度: O(n)
 * 空间复杂度: O(1)
 *
 * @author cheng
 *         2018/8/3 15:02
 */
public class PostorderSolution {
    public List<Integer> postorderTraversal(TreeNode root) {

        ArrayList<Integer> res = new ArrayList<>();

        postorderTraversal(root, res);
        return res;
    }

    private void postorderTraversal(TreeNode node, ArrayList<Integer> res) {

        if (node == null) {
            return;
        }

        postorderTraversal(node.left, res);
        postorderTraversal(node.right, res);
        res.add(node.val);
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

        System.out.println(new PostorderSolution().postorderTraversal(root));
    }
}
