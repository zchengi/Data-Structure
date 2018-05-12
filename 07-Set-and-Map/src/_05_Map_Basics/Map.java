package _05_Map_Basics;

/**
 * @author cheng
 *         2018/5/12 16:10
 */
public interface Map<K, V> {

    void add(K key, V value);

    V get(K key);

    void set(K key, V newValue);

    V remove(K key);

    boolean contains(K key);

    int getSize();

    boolean isEmpty();
}
