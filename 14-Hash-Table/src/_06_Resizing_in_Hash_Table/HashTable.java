package _06_Resizing_in_Hash_Table;

import java.util.TreeMap;

/**
 * @author cheng
 *         2018/8/2 18:17
 */
public class HashTable<K, V> {

    private static final int upperTol = 10;
    private static final int lowerTol = 2;
    private static final int initCapacity = 7;

    private TreeMap<K, V>[] hashTable;
    private int M;
    private int size;

    public HashTable() {
        this(initCapacity);
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

            if (size >= upperTol * M) {
                resize(2 * M);
            }
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

            if (size < lowerTol * M && M / 2 >= initCapacity) {
                resize(M / 2);
            }
        }
        return ret;
    }

    public boolean contains(K key) {
        return hashTable[hash(key)].containsKey(key);
    }

    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    private void resize(int newM) {
        TreeMap<K, V>[] newHashTable = new TreeMap[newM];
        for (int i = 0; i < newM; i++) {
            newHashTable[i] = new TreeMap<>();
        }

        int oldM = M;
        this.M = newM;
        for (int i = 0; i < oldM; i++) {
            TreeMap<K, V> map = hashTable[i];
            for (K key : map.keySet()) {
                newHashTable[hash(key)].put(key, map.get(key));
            }
        }

        this.hashTable = newHashTable;
    }

    private int getSize() {
        return size;
    }
}
