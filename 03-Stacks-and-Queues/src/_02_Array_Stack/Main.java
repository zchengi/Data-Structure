package _02_Array_Stack;

/**
 * @author cheng
 *         2018/5/9 16:24
 */
public class Main {
    public static void main(String[] args) {

        ArrayStack<Integer> stack = new ArrayStack<>();

        for (int i = 0; i < 5; i++) {
            stack.push(i);
            System.out.println(stack);
        }

        stack.pop();
        System.out.println(stack);
    }
}
