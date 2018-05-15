package utils;

/**
 * @author cheng
 *         2018/5/15 11:32
 */
public interface Merger<E> {

    E merge(E a, E b);
}
