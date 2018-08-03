package _Option_05_Binary_Tree_Morris_Traversal;


import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树后序遍历：Postorder Morris Traversal
 * <p>
 * 时间复杂度: O(n)
 * 空间复杂度: O(1)
 *
 * @author cheng
 *         2018/8/3 16:10
 */
public class PostorderSolution {
    public List<Integer> postorderTraversal(TreeNode root) {

        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        TreeNode dummyRoot = new TreeNode(-1);
        dummyRoot.left = root;

        TreeNode cur = dummyRoot;
        while (cur != null) {
            if (cur.left == null) {
                cur = cur.right;
            } else {
                TreeNode pre = cur.left;
                while (pre.right != null && pre.right != cur) {
                    pre = pre.right;
                }

                if (pre.right == null) {
                    pre.right = cur;
                    cur = cur.left;
                } else {
                    pre.right = null;
                    reverseTraversal(cur.left, res);
                    cur = cur.right;
                }
            }
        }

        return res;
    }

    private void reverseTraversal(TreeNode node, ArrayList<Integer> res) {

        int start = res.size();
        while (node != null) {
            res.add(node.val);
            node = node.right;
        }

        int i = start, j = res.size() - 1;
        while (i < j) {
            int t = res.get(i);
            res.set(i, res.get(j));
            res.set(j, t);

            i++;
            j--;
        }
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
