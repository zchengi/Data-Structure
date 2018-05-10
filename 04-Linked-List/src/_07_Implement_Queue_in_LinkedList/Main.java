package _07_Implement_Queue_in_LinkedList;

import utils.Queue;

import java.util.Random;

/**
 * 数组队列、循环队列、链表队列 比较
 * <p>
 * 对于数据量为十万，测试次数为 10 次，计算每次测试的平均耗时：
 * 数组队列的耗时几乎是循环队列的 100 倍
 *
 * @author cheng
 *         2018/5/9 22:05
 */
public class Main {

    /**
     * 测试使用 q 运行 opCount 个 enqueue() 和 dequeue() 操作所需要的时间，单位：秒
     *
     * @param q
     * @param opCount
     * @return
     */
    private static double testQueue(Queue<Integer> q, int opCount, int testCount) {

        long startTime = System.nanoTime();

        Random random = new Random();

        for (int i = 0; i < testCount; i++) {
            for (int j = 0; j < opCount; j++) {
                q.enqueue(random.nextInt(Integer.MAX_VALUE));
            }
            for (int j = 0; j < opCount; j++) {
                q.dequeue();
            }
        }

        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0 / testCount;
    }

    public static void main(String[] args) {

        int opCount = 100000;
        int testCount = 10;

        System.out.println("Queues Comparison, optionCount = " + opCount + ", testCount = " + testCount);
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>(opCount);
        double time1 = testQueue(arrayQueue, opCount, testCount);
        System.out.println("ArrayQueue, average time: " + time1 + "s");

        LoopQueue<Integer> loopQueue = new LoopQueue<>(opCount);
        double time2 = testQueue(loopQueue, opCount, testCount);
        System.out.println("LoopQueue, average time: " + time2 + "s");

        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();
        double time3 = testQueue(linkedListQueue, opCount, testCount);
        System.out.println("LinkedListQueue, average time: " + time3 + "s");
    }
}
