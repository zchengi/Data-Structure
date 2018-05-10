package _04_Query_and_Update_in_LinkedList;

/**
 * @author cheng
 *         2018/5/10 11:27
 */
public class Main {
    public static void main(String[] args) {

        LinkedList<Integer> linkedList = new LinkedList<>();

        for (int i = 0; i < 5; i++) {
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }

        linkedList.add(2, 666);
        System.out.println(linkedList);
    }
}
