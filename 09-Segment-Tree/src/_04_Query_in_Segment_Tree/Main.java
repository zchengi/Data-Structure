package _04_Query_in_Segment_Tree;

/**
 * @author cheng
 *         2018/5/15 11:57
 */
public class Main {
    public static void main(String[] args) {

        Integer[] arr = {-2, 0, 3, -5, 2, -1};

        SegmentTree<Integer> segTree = new SegmentTree<>(arr, (a, b) -> a + b);
        System.out.println(segTree);

        System.out.println("区间 [0, 2] 的和: " + segTree.query(0, 2));
        System.out.println("区间 [2, 5] 的和: " + segTree.query(2, 5));
        System.out.println("区间 [0, 5] 的和: " + segTree.query(0, 5));
        System.out.println("区间 [0, 3] 的和: " + segTree.query(0, 3));
    }
}
