package utils;

/**
 * @author cheng
 *         2018/5/9 20:12
 */
public interface Queue<E> {

    void enqueue(E e);

    E dequeue();

    E getFront();

    int getSize();

    boolean isEmpty();
}
