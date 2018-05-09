package _06_Generic_Data_Structures;

/**
 * @author cheng
 *         2018/5/9 11:37
 */
public class Main {
    public static void main(String[] args) {

        Array<String> arr = new Array<>(20);

        int size = 10;
        for (int i = 0; i < size; i++) {
            arr.addLast(String.valueOf(i+"zz"));
        }
        System.out.println(arr);

        arr.add(1, String.valueOf(100));
        System.out.println(arr);

        arr.addFirst(String.valueOf(-1));
        System.out.println(arr);

        arr.addLast(String.valueOf(233));
        System.out.println(arr.find(String.valueOf(233)));
        System.out.println(arr.removeElement(String.valueOf(233)));
        System.out.println(arr.removeElement(String.valueOf(233)));

        arr.addLast(String.valueOf(233));
        arr.addLast(String.valueOf(233));
        arr.addLast(String.valueOf(233));
        System.out.println(arr.findAll(String.valueOf(233)));
        System.out.println(arr.removeAllElement(String.valueOf(233)));
        System.out.println(arr.removeAllElement(String.valueOf(233)));

        System.out.println(arr);
        System.out.println(arr.removeFirst());
        System.out.println(arr.removeLast());
    }
}
