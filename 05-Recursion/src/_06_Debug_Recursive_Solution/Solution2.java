package _06_Debug_Recursive_Solution;

import utils.ListNode;

/**
 * LeetCode 203. Remove Linked List Elements
 * <p>
 * 使用递归解决
 *
 * @author cheng
 *         2018/5/10 17:36
 */
public class Solution2 {
    public ListNode removeElements(ListNode head, int val, int depth) {

        String depthString = generateDepthString(depth);

        System.out.print(depthString);
        System.out.println("Call: remove " + val + " in " + head);

        if (head == null) {
            System.out.print(depthString);
            System.out.println("Return: " + head);
            return null;
        }

        ListNode res = removeElements(head.next, val, depth + 1);
        System.out.print(depthString);
        System.out.println("After remove " + val + ": " + res);

        ListNode ret;
        if (head.val == val) {
            ret = res;
        } else {
            head.next = res;
            ret = head;
        }

        System.out.print(depthString);
        System.out.println("Return: " + ret);
        return ret;
    }

    private String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            res.append("--");
        }
        return res.toString();
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 6, 3, 4, 5, 6};
        ListNode listNode = new ListNode(arr);
        System.out.println(listNode);
        System.out.println(new Solution2().removeElements(listNode, 6, 0));
    }
}
