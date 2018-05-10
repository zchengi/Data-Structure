package _06_Implement_Stack_in_LinkedList;

import utils.Stack;

import java.util.Random;

/**
 * 差异并不大，因为从理论分析二者的时间复杂度不大
 *
 * @author cheng
 *         2018/5/10 12:01
 */
public class Main {

    /**
     * 测试使用 stack 运行 opCount 个 push和pop 操作所需的时间，单位：秒
     *
     * @param stack
     * @param opCount
     * @return
     */
    private static double testStack(Stack<Integer> stack, int opCount) {

        long startTime = System.nanoTime();

        Random random = new Random();

        for (int j = 0; j < opCount; j++) {
            stack.push(random.nextInt(Integer.MAX_VALUE));
        }
        for (int j = 0; j < opCount; j++) {
            stack.pop();
        }

        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {

        // 100000 10000000
        int opCount = 10000000;

        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        double time1 = testStack(arrayStack, opCount);
        System.out.println("ArrayStack, time: " + time1 + "s");

        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();
        double time2 = testStack(linkedListStack, opCount);
        System.out.println("LinkedListStack, time: " + time2 + "s");

        // 其实这个时间比较很复杂，因为 LinkListStack 中包含更多的 new 操作
    }
}
