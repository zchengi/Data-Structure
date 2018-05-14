package utils;

/**
 * @author cheng
 *         2018/5/14 16:55
 */
public interface Queue<E> {

    void enqueue(E e);

    E dequeue();

    E getFront();

    int getSize();

    boolean isEmpty();
}
