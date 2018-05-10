package utils;

/**
 * @author cheng
 *         2018/5/9 16:05
 */
public interface Stack<E> {

    void push(E e);

    E pop();

    E peek();

    int getSize();

    boolean isEmpty();
}
