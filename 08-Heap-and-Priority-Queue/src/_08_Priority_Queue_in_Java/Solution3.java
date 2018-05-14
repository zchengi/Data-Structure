package _08_Priority_Queue_in_Java;

import java.util.*;

/**
 * LeetCode 347. Top K Frequent Elements
 *
 * @author cheng
 *         2018/5/14 18:19
 */
public class Solution3 {

    private class Freq {

        private int e, freq;

        public Freq(int e, int freq) {
            this.e = e;
            this.freq = freq;
        }
    }

    public List<Integer> topKFrequent(int[] nums, int k) {

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        // PriorityQueue<Freq> pq = new PriorityQueue<>((a, b) -> a.freq - b.freq);
        PriorityQueue<Freq> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.freq));
        for (int key : map.keySet()) {
            if (pq.size() < k) {
                pq.add(new Freq(key, map.get(key)));
            } else if (map.get(key) > pq.peek().freq) {
                pq.remove();
                pq.add(new Freq(key, map.get(key)));
            }
        }

        LinkedList<Integer> res = new LinkedList<>();
        while (!pq.isEmpty()) {
            res.add(pq.remove().e);
        }
        return res;
    }

    private static void printList(List<Integer> nums) {
        for (Integer num : nums) {
            System.out.print(num + " ");
        }
    }

    public static void main(String[] args) {

        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        printList((new Solution3()).topKFrequent(nums, k));
    }
}
