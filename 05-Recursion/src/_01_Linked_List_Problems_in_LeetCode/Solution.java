package _01_Linked_List_Problems_in_LeetCode;

import utils.ListNode;

/**
 * LeetCode 203. Remove Linked List Elements
 *
 * @author cheng
 *         2018/5/10 15:08
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode prev = dummyHead;

        while (prev.next != null) {
            ListNode cur = prev.next;
            if (cur.val == val) {
                prev.next = cur.next;
                cur.next = null;
            } else {
                prev = prev.next;
            }
        }

        return dummyHead.next;
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 6, 3, 4, 5, 6};
        ListNode listNode = new ListNode(arr);
        System.out.println(new Solution().removeElements(listNode, 6));
    }
}
