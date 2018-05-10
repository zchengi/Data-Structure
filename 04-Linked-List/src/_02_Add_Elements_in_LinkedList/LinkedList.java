package _02_Add_Elements_in_LinkedList;

/**
 * @author cheng
 *         2018/5/10 10:50
 */
public class LinkedList<E> {

    private Node head;

    private int size;

    public LinkedList() {
        head = null;
        size = 0;
    }

    public LinkedList(E[] arr) {

        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Arr cannot be empty.");
        }

        head = new Node(arr[0], null);
        Node cur = head;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new Node(arr[i], null);
            cur = cur.next;
        }
        size = arr.length;
    }

    /**
     * 在链表头添加新的元素 e
     *
     * @param e
     */
    public void addFirst(E e) {

        /*Node node = new Node(e);
        node.next = head;
        head = node;*/

        head = new Node(e, head);
        size++;
    }

    /**
     * 在链表的 index(0-based) 位置添加新的元素 e
     * 在链表中不是一个常用的操作，练习用
     *
     * @param index
     * @param e
     */
    public void add(int index, E e) {

        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }

        if (index == 0) {
            addFirst(e);
        } else {
            Node prev = head;
            for (int i = 0; i < index - 1; i++) {
                prev = prev.next;
            }

            /*Node node = new Node(e);
            node.next = prev.next;
            prev.next = node;*/

            prev.next = new Node(e, prev.next);
            size++;
        }
    }

    /**
     * 在链表末尾添加新的元素 e
     *
     * @param e
     */
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * 获取链表中的元素个数
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 返回链表是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }
}
