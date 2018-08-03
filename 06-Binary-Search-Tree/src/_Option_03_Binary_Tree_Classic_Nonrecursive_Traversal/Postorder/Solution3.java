package _Option_03_Binary_Tree_Classic_Nonrecursive_Traversal.Postorder;


import _Option_03_Binary_Tree_Classic_Nonrecursive_Traversal.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树后序遍历：循环实现
 * <p>
 * using two stack, Reverse Preorder Traversal
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 *
 * @author cheng
 *         2018/8/3 15:36
 */
public class Solution3 {
    public List<Integer> postorderTraversal(TreeNode root) {


        Stack<TreeNode> stack = new Stack<>();
        LinkedList<TreeNode> output = new LinkedList<>();

        TreeNode p = root;
        while (p != null || !stack.isEmpty()) {

            if (p != null) {
                stack.push(p);
                output.push(p);
                p = p.right;
            } else {
                p = stack.pop();
                p = p.left;
            }
        }

        ArrayList<Integer> res = new ArrayList<>();

        while (!output.isEmpty()) {
            res.add(output.pop().val);
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

        System.out.println(new Solution3().postorderTraversal(root));
    }
}
