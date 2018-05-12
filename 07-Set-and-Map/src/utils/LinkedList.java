package utils;

/**
 * @author cheng
 *         2018/5/10 11:31
 */
public class LinkedList<E> {

    private Node dummyHead;

    private int size;

    public LinkedList() {
        dummyHead = new Node(null, null);
        size = 0;
    }

    public LinkedList(E[] arr) {

        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Arr cannot be empty.");
        }

        dummyHead = new Node(null, new Node(arr[0], null));
        Node cur = dummyHead.next;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new Node(arr[i], null);
            cur = cur.next;
        }
        size = arr.length;
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

        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }

        prev.next = new Node(e, prev.next);
        size++;
    }

    /**
     * 在链表头添加新的元素 e
     *
     * @param e
     */
    public void addFirst(E e) {
        add(0, e);
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
     * 获得链表的第 index(0-based) 个位置的元素
     * 在链表中不是一个常用的操作，练习用
     *
     * @param index
     * @return
     */
    public E get(int index) {

        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed. Illegal index.");
        }

        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }

        return cur.e;
    }

    /**
     * 获得链表的第一个元素
     *
     * @return
     */
    public E getFirst() {
        return get(0);
    }

    /**
     * 获得链表的最后一个元素
     *
     * @return
     */
    public E getLast() {
        return get(size - 1);
    }

    /**
     * 修改链表第 index(0-based) 个位置的元素 e
     * 在链表中不是一个常用的操作，练习用
     *
     * @param index
     * @param e
     */
    public void set(int index, E e) {

        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Set failed. Illegal index.");
        }

        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }

    /**
     * 删除链表第 index(0-based) 个位置的元素 e
     * 在链表中不是一个常用的操作，练习用
     *
     * @param index
     * @return
     */
    public E remove(int index) {

        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Remove failed. Illegal index.");
        }

        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }

        Node retNode = prev.next;
        prev.next = retNode.next;
        retNode.next = null;
        size--;

        return retNode.e;
    }

    /**
     * 从链表中删除第一个元素，返回删除的元素
     *
     * @return
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * 从链表中删除最后一个元素，返回删除的元素
     *
     * @return
     */
    public E removeLast() {
        return remove(size - 1);
    }

    /**
     * 从链表中删除元素 e
     *
     * @param e
     */
    public void removeElement(E e) {

        Node prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.e.equals(e)) {
                break;
            }
            prev = prev.next;
        }

        if (prev.next != null) {
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            size--;
        }
    }

    /**
     * 查找链表中是否有元素 e
     *
     * @param e
     * @return
     */
    public boolean contains(E e) {

        Node cur = dummyHead.next;

        while (cur != null) {
            if (cur.e.equals(e)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
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

    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();

        /*for (Node cur = dummyHead.next; cur != null; cur = cur.next) {
            res.append(cur).append("->");
        }*/

        Node cur = dummyHead.next;
        while (cur != null) {
            res.append(cur).append(" -> ");
            cur = cur.next;
        }
        res.append("NULL");

        return res.toString();
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
