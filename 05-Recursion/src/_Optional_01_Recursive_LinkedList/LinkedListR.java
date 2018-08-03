package _Optional_01_Recursive_LinkedList;

import javafx.util.Pair;

/**
 * 递归实现 LInkedLIst
 * 类名称 LinkedListR 中的 R 表示 Recursion 的意思，表示递归实现
 *
 * @author cheng
 *         2018/8/3 10:38
 */
public class LinkedListR<E> {

    /**
     * 在链表的递归实现中，不使用虚拟头结点，也能无差异的处理位置 0 的问题
     */
    public Node head;
    private int size;

    public LinkedListR() {
        head = null;
        size = 0;
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
     * 在链表尾添加新的元素 e
     *
     * @param e
     */
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * 在链表的 index(0-based) 位置添加新的元素 e
     *
     * @param index
     * @param e
     */
    public void add(int index, E e) {

        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }

        head = add(head, index, e);
        size++;
    }

    /**
     * 在以 node 为头节点的链表的 index 位置插入元素 e，递归算法
     *
     * @param node
     * @param index
     * @param e
     * @return
     */
    private Node add(Node node, int index, E e) {

        if (index == 0) {
            return new Node(e, node);
        }

        node.next = add(node.next, index - 1, e);
        return node;
    }

    /**
     * 获取链表的第一个元素
     *
     * @return
     */
    public E getFirst() {
        return get(0);
    }

    /**
     * 获取链表的最后一个元素
     *
     * @return
     */
    public E getLast() {
        return get(size - 1);
    }

    /**
     * 获得链表的第 index(0-based) 个位置的元素
     *
     * @param index
     * @return
     */
    public E get(int index) {

        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed. Illegal index.");
        }

        return get(head, index);
    }

    /**
     * 在以 node 为头节点的链表中，找到第 index 个元素，递归算法
     *
     * @param node
     * @param index
     * @return
     */
    private E get(Node node, int index) {

        if (index == 0) {
            return node.e;
        }
        return get(node.next, index - 1);
    }


    /**
     * 修改链表的第 index(0-based) 个位置的元素为 e
     *
     * @param index
     * @param e
     */
    public void set(int index, E e) {

        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Update failed. Illegal index.");
        }

        set(head, index, e);
    }

    /**
     * 修改以 node 为头节点的链表中，第 index(0-based) 个位置的元素 e，递归算法
     *
     * @param node
     * @param index
     * @param e
     */
    private void set(Node node, int index, E e) {

        if (index == 0) {
            node.e = e;
            return;
        }
        set(node.next, index - 1, e);
    }

    /**
     * 从链表中删除第一个元素，返回删除的元素
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * 从链表中删除最后一个元素，返回删除的元素
     */
    public E removeLast() {
        return remove(size - 1);
    }

    /**
     * 从链表中删除 index(0-based) 位置的元素，返回删除元素的值
     *
     * @param index
     * @return
     */
    public E remove(int index) {

        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Remove failed. Illegal index.");
        }

        Pair<Node, E> res = remove(head, index);
        size--;

        head = res.getKey();
        return res.getValue();
    }

    /**
     * 从以 node 为头结点的链表中，删除第 index 位置的元素，递归算法
     * 返回值包含两个元素，删除后的链表头节点和删除的值
     *
     * @param node
     * @param index
     * @return
     */
    private Pair<Node, E> remove(Node node, int index) {

        if (index == 0) {
            return new Pair<>(node.next, node.e);
        }

        Pair<Node, E> res = remove(node.next, index - 1);
        node.next = res.getKey();
        return new Pair<>(node, res.getValue());
    }

    /**
     * 从链表中删除元素 e
     *
     * @param e
     */
    public void removeElement(E e) {
        head = removeElement(head, e);
    }

    /**
     * 从以 node 为头节点的链表中，删除元素 e，递归算法
     *
     * @param node
     * @param e
     * @return
     */
    private Node removeElement(Node node, E e) {
        if (node == null) {
            return null;
        }
        if (node.e.equals(e)) {
            size--;
            return node.next;
        }

        node.next = removeElement(node.next, e);
        return node;
    }

    /**
     * 查找链表中是否有元素 e
     *
     * @param e
     * @return
     */
    public boolean contains(E e) {
        return contains(head, e);
    }

    /**
     * 在以 node 为头结点的链表中，查找是否存在元素 e，递归算法
     *
     * @param node
     * @param e
     * @return
     */
    private boolean contains(Node node, E e) {
        if (node == null) {
            return false;
        }
        if (node.e.equals(e)) {
            return true;
        }
        return contains(node.next, e);
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

    public String toString() {

        StringBuilder builder = new StringBuilder();
        Node cur = head;
        while (cur != null) {
            builder.append(cur).append("->");
            cur = cur.next;
        }
        builder.append("NULL");

        return builder.toString();
    }

    private class Node {
        private E e;
        private Node next;

        public Node() {
            this(null, null);
        }

        public Node(E e) {
            this(e, null);
        }

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    public static void main(String[] args) {

        LinkedListR<Integer> linkedList = new LinkedListR<>();

        linkedList.addFirst(1);
        linkedList.addFirst(2);
        linkedList.addFirst(3);
        linkedList.addFirst(4);
        linkedList.addLast(5);
        System.out.println(linkedList);

        System.out.println(linkedList.removeFirst());
        System.out.println(linkedList.removeLast());
        linkedList.removeElement(2);
        System.out.println(linkedList);
        System.out.println(linkedList.contains(3));
        System.out.println(linkedList.get(0));
        System.out.println(linkedList.getSize());
    }
}
