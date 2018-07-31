package _08_The_Performance_of_Red_Black_Tree;

import utils.AVLTree;
import utils.BST;
import utils.FileOperation;
import utils.RBTree;

import java.util.ArrayList;

/**
 * 测试  BST  AVL  RBTree 的性能
 *
 * @author cheng
 *         2018/7/31 16:13
 */
public class Main {
    public static void main(String[] args) {

        System.out.println("Pride and Prejudice");

        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile("13-Red-Black-Tree/src/txt/pride-and-prejudice.txt", words)) {
            System.out.println("Total words: " + words.size());

            // Collections.sort(words);

            // Test BST
            long startTime = System.nanoTime();

            BST<String, Integer> bst = new BST<>();
            for (String word : words) {
                if (bst.contains(word))
                    bst.set(word, bst.get(word) + 1);
                else
                    bst.add(word, 1);
            }

            for (String word : words)
                bst.contains(word);

            long endTime = System.nanoTime();

            double time = (endTime - startTime) / 1000000000.0;
            System.out.println("BST: " + time + " s");


            // Test AVL
            startTime = System.nanoTime();

            AVLTree<String, Integer> avl = new AVLTree<>();
            for (String word : words) {
                if (avl.contains(word))
                    avl.set(word, avl.get(word) + 1);
                else
                    avl.add(word, 1);
            }

            for (String word : words)
                avl.contains(word);

            endTime = System.nanoTime();

            time = (endTime - startTime) / 1000000000.0;
            System.out.println("AVL: " + time + " s");


            // Test RBTree
            startTime = System.nanoTime();

            RBTree<String, Integer> rbt = new RBTree<>();
            for (String word : words) {
                if (rbt.contains(word))
                    rbt.set(word, rbt.get(word) + 1);
                else
                    rbt.add(word, 1);
            }

            for (String word : words)
                rbt.contains(word);

            endTime = System.nanoTime();

            time = (endTime - startTime) / 1000000000.0;
            System.out.println("RBTree: " + time + " s");
        }

        System.out.println();
    }
}
/*
 * 测试结果：
 *      Pride and Prejudice
 *      Total words: 125901
 *      BST: 0.134998822 s
 *      AVL: 0.132750179 s
 *      RBTree: 0.139102828 s
 * 可以得到的结论：
 *      红黑树的运行效率并不占优，甚至比二分搜索树更慢一些，主要的原因：
 *          1. 测试用例比较小，所以可能更简单的算法，由于操作更少，反而更快一些；
 *             也就说明了并不是在任何情况下越复杂的算法，或者说看起来时间复杂度更低的算法就是更好的；
 *          2. 大多数操作都是在进行查询的操作；
 *
 */