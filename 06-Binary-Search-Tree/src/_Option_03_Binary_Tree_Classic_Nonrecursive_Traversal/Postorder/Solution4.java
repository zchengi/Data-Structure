package _Option_03_Binary_Tree_Classic_Nonrecursive_Traversal.Postorder;


import _Option_03_Binary_Tree_Classic_Nonrecursive_Traversal.util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树后序遍历：循环实现
 * <p>
 * Using a pre pointer to record the last visted node
 * 时间复杂度：O(n)
 * 空间复杂度：O(h)
 *
 * @author cheng
 *         2018/8/3 15:36
 */
public class Solution4 {
    public List<Integer> postorderTraversal(TreeNode root) {

        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;

        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();

            if ((cur.left == null && cur.right == null)
                    || (pre != null && pre == cur.left && cur.right == null)
                    || (pre != null && pre == cur.right)) {
                res.add(cur.val);
                pre = cur;
            } else {
                stack.push(cur);
                if (cur.right != null) {
                    stack.push(cur.right);
                }
                if (cur.left != null) {
                    stack.push(cur.left);
                }
            }
        }
        return res;
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

        System.out.println(new Solution4().postorderTraversal(root));
    }
}
