package utils;

/**
 * @author cheng
 *         2018/5/10 15:09
 */
public class ListNode {

    public int val;

    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public ListNode(int[] arr) {

        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Arr can not be empty.");
        }

        this.val = arr[0];
        ListNode curNode = this;
        for (int i = 1; i < arr.length; i++) {
            curNode.next = new ListNode(arr[i]);
            curNode = curNode.next;
        }
    }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();
        ListNode curNode = this;
        while (curNode != null) {
            builder.append(curNode.val);
            builder.append(" -> ");
            curNode = curNode.next;
        }

        return builder.append("NULL").toString();
    }
}
