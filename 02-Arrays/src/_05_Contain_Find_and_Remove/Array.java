package _05_Contain_Find_and_Remove;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cheng
 *         2018/5/8 21:00
 */
public class Array {

    private int[] data;

    private int size;

    /**
     * 构造函数，传入数组的容量 capacity 构造 Array
     *
     * @param capacity
     */
    public Array(int capacity) {
        data = new int[capacity];
        size = 0;
    }

    /**
     * 无参数的构造函数，默认数组的容量 capacity = 10
     */
    public Array() {
        this(10);
    }

    /**
     * 构造函数，传入一个静态数组，生成一个 Array 类的对象
     *
     * @param array
     */
    public Array(int[] array) {

        size = array.length;
        data = new int[size];
        System.arraycopy(array, 0, data, 0, array.length);
    }

    /**
     * 获取数组中的元素个数
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 获取数组的容量
     *
     * @return
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * 返回数组是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 向所有元素后添加一个新元素
     *
     * @param e
     */
    public void addLast(int e) {
        add(size, e);
    }

    /**
     * 向所有元素前添加一个新元素
     *
     * @param e
     */
    public void addFirst(int e) {
        add(0, e);
    }

    /**
     * 在第 index 个位置插入一个新元素 e
     *
     * @param index
     * @param e
     */
    public void add(int index, int e) {

        if (index < 0 || index > size) {
            throw new IllegalArgumentException("AddLast failed. Require index >= 0 and index <= size.");
        }
        if (size == data.length) {
            throw new IllegalArgumentException("AddLast failed. Array is full.");
        }

        /*for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }*/
        System.arraycopy(data, index, data, index + 1, size - index);

        data[index] = e;
        size++;
    }

    /**
     * 修改 index 索引位置的元素
     *
     * @param index
     * @param e
     */
    public void set(int index, int e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Set failed. Index is illegal.");
        }
        data[index] = e;
    }

    /**
     * 获取 index 索引位置的元素
     *
     * @param index
     * @return
     */
    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        }
        return data[index];
    }

    /**
     * 查找数组中是否有元素 e
     *
     * @return
     */
    public boolean contains(int e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
                return true;
            }
        }
        return false;
    }

    /**
     * 查找数组中元素 e 所在的索引(第一次找到的元素)，如果不存在元素 e，则返回 -1
     *
     * @param e
     * @return
     */
    public int find(int e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 查找数组中元素 e 所在的所有索引
     *
     * @param e
     * @return
     */
    public List<Integer> findAll(int e) {

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
                res.add(i);
            }
        }

        return res;
    }

    /**
     * 从数组中删除 index 位置的元素，返回删除的元素
     *
     * @param index
     * @return
     */
    public int remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Remove failed. Index is illegal.");
        }

        int res = data[index];

        /*for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }*/
        System.arraycopy(data, index + 1, data, index, size - (index + 1));

        size--;
        return res;
    }

    /**
     * 从数组中删除第一个元素，返回删除的元素
     *
     * @return
     */
    public int removeFirst() {
        return remove(0);
    }

    /**
     * 从数组中删除最后一个元素，返回删除的元素
     *
     * @return
     */
    public int removeLast() {
        return remove(size - 1);
    }

    /**
     * 从数组中删除元素(只删除找到的第一个元素) e
     *
     * @param e
     * @return
     */
    public boolean removeElement(int e) {

        int index = find(e);
        if (index != -1) {
            remove(index);
            return true;
        }

        return false;
    }

    /**
     * 从数组中删除所有元素 e
     *
     * @param e
     * @return
     */
    public boolean removeAllElement(int e) {

        boolean flag = false;
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
                // 因为删除一个元素后，该元素之后的所有元素向前移动一位，所以 i--，再从当前元素查找
                remove(i--);
                flag = true;
            }
        }

        return flag;
    }

    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();
        res.append(String.format("Array : size = %d , capacity = %d\n", size, data.length));
        res.append('[');
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1) {
                res.append(", ");
            }
        }
        res.append("]");

        return res.toString();
    }
}