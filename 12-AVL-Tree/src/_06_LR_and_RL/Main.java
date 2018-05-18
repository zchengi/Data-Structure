package _06_LR_and_RL;

import utils.BST;
import utils.FileOperation;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author cheng
 *         2018/5/18 16:27
 */
public class Main {
    public static void main(String[] args) {

        System.out.println("Pride and Prejudice");

        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile("12-AVL-Tree/src/txt/pride-and-prejudice.txt", words)) {

            // 测试最差情况，顺序添加数据，BST退化为链表，AVL依然很快
            Collections.sort(words);

            // Test BST
            long startTime = System.nanoTime();

            BST<String, Integer> bst = new BST<>();
            for (String word : words) {
                if (bst.contains(word)) {
                    bst.set(word, bst.get(word) + 1);
                } else {
                    bst.add(word, 1);
                }
            }
            for (String word : words) {
                bst.contains(word);
            }

            long endTime = System.nanoTime();

            double time = (endTime - startTime) / 1000000000.0;
            System.out.println("BST: " + time + " s");

            // Test AVL Tree
            startTime = System.nanoTime();

            AVLTree<String, Integer> avl = new AVLTree<>();
            for (String word : words) {
                if (avl.contains(word)) {
                    avl.set(word, avl.get(word) + 1);
                } else {
                    avl.add(word, 1);
                }
            }
            for (String word : words) {
                avl.contains(word);
            }

            endTime = System.nanoTime();

            time = (endTime - startTime) / 1000000000.0;
            System.out.println("AVL: " + time + " s");
        }
    }
}
