package _03_Building_Segment_Tree;

/**
 * @author cheng
 *         2018/5/15 11:35
 */
public class Main {
    public static void main(String[] args) {

        Integer[] arr = {-2, 0, 3, -5, 2};
        SegmentTree<Integer> segmentTree = new SegmentTree<>(arr, (a, b) -> a + b);
        System.out.println(segmentTree);
    }
}
