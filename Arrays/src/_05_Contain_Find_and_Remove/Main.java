package _05_Contain_Find_and_Remove;

/**
 * @author cheng
 *         2018/5/8 21:15
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

        arr.addLast(233);
        System.out.println(arr.find(233));
        System.out.println(arr.removeElement(233));
        System.out.println(arr.removeElement(233));

        arr.addLast(233);
        arr.addLast(233);
        arr.addLast(233);
        System.out.println(arr.findAll(233));
        System.out.println(arr.removeAllElement(233));
        System.out.println(arr.removeAllElement(233));

        System.out.println(arr);
        System.out.println(arr.removeFirst());
        System.out.println(arr.removeLast());
    }
}
