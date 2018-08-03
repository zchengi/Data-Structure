package _Option_05_Binary_Tree_Morris_Traversal;


import _Option_04_Binary_Tree_Classic_Recursive_Traversal.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树前序遍历：Preorder Morris Traversal
 * <p>
 * 时间复杂度: O(n)
 * 空间复杂度: O(1)
 *
 * @author cheng
 *         2018/8/3 16:05
 */
public class PreorderSolution {
    public List<Integer> preorderTraversal(TreeNode root) {

        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        TreeNode cur = root;
        while (cur != null) {
            if (cur.left == null) {
                res.add(cur.val);
                cur = cur.right;
            } else {
                TreeNode prev = cur.left;
                while (prev.right != null && prev.right != cur) {
                    prev = prev.right;
                }

                if (prev.right == null) {
                    res.add(cur.val);
                    prev.right = cur;
                    cur = cur.left;
                } else {
                    prev.right = null;
                    cur = cur.right;
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

        System.out.println(new PreorderSolution().preorderTraversal(root));
    }
}
