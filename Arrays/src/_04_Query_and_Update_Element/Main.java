package _04_Query_and_Update_Element;

/**
 * @author cheng
 *         2018/5/8 20:30
 */
public class Main {
    public static void main(String[] args) {

        Array arr = new Array(20);

        int size = 10;
        for (int i = 0; i < size; i++) {
            arr.addLast(i);
        }
        System.out.println(arr);

        arr.add(1, 100);
        System.out.println(arr);

        arr.addFirst(-1);
        System.out.println(arr);
    }
}
