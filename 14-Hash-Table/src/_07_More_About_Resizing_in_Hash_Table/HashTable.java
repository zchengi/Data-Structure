package _07_More_About_Resizing_in_Hash_Table;

import java.util.TreeMap;

/**
 * @author cheng
 *         2018/8/2 18:37
 */
public class HashTable<K, V> {

    private final int[] capacity = {53, 97, 193, 389, 769, 1543, 3079, 6151, 12289, 24593,
            49157, 98317, 196613, 393241, 786433, 1572869, 3145739, 6291469, 12582917,
            25165843, 50331653, 100663319, 201326611, 402653189, 805306457, 1610612741};

    private static final int UPPER_TOL = 10;
    private static final int LOWER_TOL = 2;
    private int capacityIndex = 0;

    private TreeMap<K, V>[] hashTable;
    private int M;
    private int size;


    public HashTable(int M) {
        this.M = capacity[capacityIndex];
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

            if (size >= UPPER_TOL * M && capacityIndex + 1 < capacity.length) {
                resize(capacity[capacityIndex++]);
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

            if (size < LOWER_TOL * M && capacityIndex >= 1) {
                resize(capacity[capacityIndex--]);
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
