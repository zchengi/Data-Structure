package _09_Amortized_Time_Compexity;

/**
 * @author cheng
 *         2018/5/9 13:48
 */
public class ShrinkageCapacityTest {
    public static void main(String[] args) {

        // 模拟缩容不添加判断 size > 0 的情况
        for (int capacity = 1; capacity < 10; capacity++) {
            Array<Integer> arr = new Array<>(capacity);

            for (int i = 0; i < capacity; i++) {
                arr.addFirst(i);
            }

            while (!arr.isEmpty()) {
                arr.removeFirst();
            }
            arr.addFirst(1);
            System.out.println("size: " + arr.getSize() + ", capacity: " + arr.getCapacity());
        }


      /*  arr.addFirst(1);
        System.out.println("size: " + arr.getSize() + ", capacity: " + arr.getCapacity());
        arr.addFirst(1);
        System.out.println("size: " + arr.getSize() + ", capacity: " + arr.getCapacity());
        arr.addFirst(1);
        System.out.println("size: " + arr.getSize() + ", capacity: " + arr.getCapacity());
        arr.addFirst(1);
        System.out.println("size: " + arr.getSize() + ", capacity: " + arr.getCapacity());

        System.out.println();
        while (!arr.isEmpty()) {
            arr.removeFirst();
            System.out.println("size: " + arr.getSize() + ", capacity: " + arr.getCapacity());
        }*/
    }
}
