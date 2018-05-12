package linkedlists;

import java.util.NoSuchElementException;

/**
 * 双向链表
 *
 * @author cheng
 *         2018/5/12 11:49
 */
public class DoubleLinkedList<E> {

    private Node head;

    private Node tail;

    private int size;

    public DoubleLinkedList() {
        tail = null;
        size = 0;
    }

    public DoubleLinkedList(E[] arr) {

        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Arr cannot be empty.");
        }

        head = new Node(null, arr[0], null);
        tail = head;
        for (int i = 1; i < arr.length; i++) {
            tail.next = new Node(tail, arr[i], null);
            tail = tail.next;
        }

        size = arr.length;
    }

    public void addFirst(E e) {

        Node newHead = new Node(null, e, head);
        if (head == null) {
            tail = newHead;
        } else {
            head.prev = newHead;
        }
        head = newHead;
        size++;
    }

    public void addLast(E e) {

        Node newLast = new Node(tail, e, null);
        if (tail == null) {
            head = newLast;
        } else {
            tail.next = newLast;
        }
        tail = newLast;
        size++;
    }

    public E getFirst() {
        if (head == null) {
            throw new NoSuchElementException("Cannot get from an empty list.");
        }
        return head.e;
    }

    public E getLast() {
        if (tail == null) {
            throw new NoSuchElementException("Cannot get from an empty list.");
        }
        return tail.e;
    }

    public E removeFirst() {

        if (size == 0) {
            throw new NoSuchElementException("Cannot remove from an empty list.");
        }

        Node removeHead = head;
        if (removeHead.next == null) {
            tail = null;
        } else {
            removeHead.next.prev = null;
        }
        head = removeHead.next;
        removeHead.next = null;

        size--;
        return removeHead.e;
    }

    public E removeLast() {

        if (size == 0) {
            throw new NoSuchElementException("Cannot remove from an empty list.");
        }

        Node removeLast = tail;
        if (removeLast.prev == null) {
            head = null;
            tail = null;
        } else {
            removeLast.prev.next = null;
        }
        tail = removeLast.prev;
        removeLast.prev = null;

        size--;
        return removeLast.e;
    }

    public boolean contains(E e) {

        Node cur = head;
        while (cur != null) {
            if (cur.e.equals(e)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    public E peek() {
        return head == null ? null : head.e;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();

        Node cur = head;
        res.append("(head) ");
        while (cur != null) {
            res.append(cur).append(" -> ");
            cur = cur.next;
        }
        res.append("(tail) NULL");

        return res.toString();
    }

    private class Node {
        private E e;
        private Node prev;
        private Node next;

        public Node(Node prev, E e, Node next) {
            this.prev = prev;
            this.e = e;
            this.next = next;
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    public static void main(String[] args) {

        Integer[] arr = {1, 2, 3, 4, 5};
        DoubleLinkedList<Integer> doubleLinkedList = new DoubleLinkedList<>(arr);
        System.out.println(doubleLinkedList);

        doubleLinkedList.addFirst(7);
        doubleLinkedList.addLast(8);
        System.out.println(doubleLinkedList);
        System.out.println("size() = " + doubleLinkedList.getSize());
        System.out.println("getFirst() = " + doubleLinkedList.getFirst());
        System.out.println("getLast() = " + doubleLinkedList.getLast());

        System.out.println("removeFirst() = " + doubleLinkedList.removeFirst());
        System.out.println("removeLast() = " + doubleLinkedList.removeLast());
        System.out.println("size() = " + doubleLinkedList.getSize());

        System.out.println("contains(2) = " + doubleLinkedList.contains(2));
        System.out.println("contains(22) = " + doubleLinkedList.contains(22));

        System.out.println(doubleLinkedList);
    }
}
