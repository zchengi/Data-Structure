package _02_My_Array;

/**
 * @author cheng
 *         2018/5/8 18:40
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
        data = new int[array.length];
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
}