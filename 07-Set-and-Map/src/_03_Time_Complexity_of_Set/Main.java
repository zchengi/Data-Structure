package _03_Time_Complexity_of_Set;

import _01_Set_Basics_and_BSTSet.BSTSet;
import _02_LinkedListSet.LinkedListSet;
import utils.FileOperation;
import utils.Set;

import java.util.ArrayList;

/**
 * 使用 BST 或 LikedList 的集合复杂度分析
 *
 * @author cheng
 *         2018/5/12 15:19
 */
public class Main {
    private static double testSet(Set<String> set, String filename) {

        long startTime = System.nanoTime();

        System.out.println(filename);
        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile("07-Set-and-Map/src/txt/" + filename + ".txt", words)) {
            System.out.println("Total words: " + words.size());

            for (String word : words) {
                set.add(word);
            }
            System.out.println("Total different words: " + set.getSize());
        }

        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {

        String filename = "pride-and-prejudice";

        BSTSet<String> bstSet = new BSTSet<>();
        double time1 = testSet(bstSet, filename);
        System.out.println("BST Set: " + time1 + " s");

        System.out.println();

        LinkedListSet<String> linkedListSet = new LinkedListSet<>();
        double time2 = testSet(linkedListSet, filename);
        System.out.println("BST Set: " + time2 + " s");
    }
}
