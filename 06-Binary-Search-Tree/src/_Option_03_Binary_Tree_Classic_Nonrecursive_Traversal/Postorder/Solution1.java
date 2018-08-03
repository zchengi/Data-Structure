package _Option_03_Binary_Tree_Classic_Nonrecursive_Traversal.Postorder;


import _Option_03_Binary_Tree_Classic_Nonrecursive_Traversal.util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树后序遍历：循环实现
 *
 * 时间复杂度：O(n)
 * 空间复杂度：O(h)
 *
 * @author cheng
 *         2018/8/3 14:57
 */
public class Solution1 {

    private class TagNode {
        TreeNode node;
        boolean isFirst;

        public TagNode(TreeNode node) {
            this.node = node;
            this.isFirst = false;
        }
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Stack<TagNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {

            while (cur != null) {
                stack.push(new TagNode(cur));
                cur = cur.left;
            }

            TagNode tagNode = stack.pop();
            cur = tagNode.node;
            if (!tagNode.isFirst) {
                tagNode.isFirst = true;
                stack.push(tagNode);
                cur = cur.right;
            } else {
                res.add(cur.val);
                cur = null;
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

        System.out.println(new Solution1().postorderTraversal(root));
    }
}
