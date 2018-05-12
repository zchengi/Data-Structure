package utils;

/**
 * @author cheng
 *         2018/5/12 14:29
 */
public interface Set<E> {

    void add(E e);

    void remove(E e);

    boolean contains(E e);

    int getSize();

    boolean isEmpty();
}
