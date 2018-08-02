package _05_Hash_Table_Implementation;

import java.util.TreeMap;

/**
 * @author cheng
 *         2018/8/2 17:38
 */
public class HashTable<K, V> {

    private TreeMap<K, V>[] hashTable;
    private int M;
    private int size;

    public HashTable() {
        this(97);
    }

    public HashTable(int M) {
        this.M = M;
        size = 0;
        hashTable = new TreeMap[M];

        for (int i = 0; i < M; i++) {
            hashTable[i] = new TreeMap<>();
        }
    }

    public void add(K key, V value) {

        TreeMap<K, V> map = hashTable[hash(key)];

        if (map.containsKey(key)) {
            map.put(key, value);
        } else {
            map.put(key, value);
            size++;
        }
    }

    public void set(K key, V value) {

        TreeMap<K, V> map = hashTable[hash(key)];
        if (!map.containsKey(key)) {
            throw new IllegalArgumentException(key + " doesn't exists.");
        }
        map.put(key, value);
    }

    public V get(K key) {
        return hashTable[hash(key)].get(key);
    }

    public V remove(K key) {

        TreeMap<K, V> map = hashTable[hash(key)];

        V ret = null;
        if (map.containsKey(key)) {
            ret = map.remove(key);
            size--;
        }
        return ret;
    }

    public boolean contains(K key) {
        return hashTable[hash(key)].containsKey(key);
    }

    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    private int getSize() {
        return size;
    }
}
