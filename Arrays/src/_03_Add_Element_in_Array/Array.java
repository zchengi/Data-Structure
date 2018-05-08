package _03_Add_Element_in_Array;

/**
 * @author cheng
 *         2018/5/8 20:19
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
}