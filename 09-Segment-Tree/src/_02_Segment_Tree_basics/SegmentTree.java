package _02_Segment_Tree_basics;

/**
 * @author cheng
 *         2018/5/15 11:16
 */
public class SegmentTree<E> {

    private E[] tree;

    private E[] data;

    public SegmentTree(E[] arr) {

        data = (E[]) new Object[arr.length];
        System.arraycopy(arr, 0, data, 0, arr.length);

        tree = (E[]) new Object[4 * arr.length];

    }

    public E get(int index) {

        if (index < 0 || index >= data.length) {
            throw new IllegalArgumentException("Index is illegal.");
        }

        return data[index];
    }

    public int getSize() {
        return data.length;
    }

    /**
     * 返回左孩子节点的索引
     *
     * @param index
     * @return
     */
    private int leftChild(int index) {
        return 2 * index + 1;
    }

    /**
     * 返回右孩子节点的索引
     *
     * @param index
     * @return
     */
    private int rightChild(int index) {
        return 2 * index + 2;
    }
}
