package queues;

import utils.Queue;

import java.util.NoSuchElementException;

/**
 * 不维护 size 的实现方式
 *
 * @author cheng
 *         2018/5/10 12:10
 */
public class LinkedListQueue2<E> implements Queue<E> {

    private Node head;

    private Node tail;

    public LinkedListQueue2() {
        head = null;
        tail = null;
    }

    @Override
    public void enqueue(E e) {

        if (tail == null) {
            tail = new Node(e, null);
            head = tail;
        } else {
            tail.next = new Node(e, null);
            tail = tail.next;
        }
    }

    @Override
    public E dequeue() {

        if (isEmpty()) {
            throw new NoSuchElementException("Cannot dequeue from an empty queue.");
        }

        Node retNode = head;
        head = head.next;
        retNode.next = null;
        if (head == null) {
            tail = null;
        }

        return retNode.e;
    }

    @Override
    public E getFront() {

        if (isEmpty()) {
            throw new NoSuchElementException("Cannot dequeue from an empty queue.");
        }

        return head.e;
    }

    @Override
    public int getSize() {

        Node cur = head;
        int size = 0;
        while (cur != null) {
            size++;
            cur = cur.next;
        }

        return size;
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();
        res.append("Queue: front ");

        Node cur = head;
        while (cur != null) {
            res.append(cur).append(" -> ");
            cur = cur.next;
        }
        res.append("NULL tail");

        return res.toString();
    }

    public class Node {
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

    public static void main(String[] args) {

        LinkedListQueue2<Integer> queue = new LinkedListQueue2<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);
            System.out.println(queue.getSize());

            if (i % 3 == 2) {
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
