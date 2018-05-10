package _01_Linked_List_Problems_in_LeetCode;

import utils.ListNode;

/**
 * LeetCode 203. Remove Linked List Elements
 * <p>
 * 使用递归解决
 *
 * @author cheng
 *         2018/5/10 16:12
 */
public class Solution2 {
    public ListNode removeElements(ListNode head, int val) {

        if (head == null) {
            return null;
        }

        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 6, 3, 4, 5, 6};
        ListNode listNode = new ListNode(arr);
        System.out.println(new Solution2().removeElements(listNode, 6));
    }
}
