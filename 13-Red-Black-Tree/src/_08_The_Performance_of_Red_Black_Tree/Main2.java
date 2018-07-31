package _08_The_Performance_of_Red_Black_Tree;

import utils.AVLTree;
import utils.BST;
import utils.RBTree;

import java.util.ArrayList;
import java.util.Random;

/**
 * 测试  BST  AVL  RBTree 的性能（只测试添加操作）
 *
 * @author cheng
 *         2018/7/31 17:01
 */
public class Main2 {
    public static void main(String[] args) {

        int n = 20000000;
        Random random = new Random(n);
        ArrayList<Integer> testData = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            testData.add(random.nextInt(Integer.MAX_VALUE));
        }

        // Test BST
        long startTime = System.nanoTime();

        BST<Integer, Integer> bst = new BST<>();
        for (int x : testData) {
            bst.add(x, null);
        }

        long endTime = System.nanoTime();

        double time = (endTime - startTime) / 1000000000.0;
        System.out.println("BST: " + time + " s");


        // Test AVL
        startTime = System.nanoTime();

        AVLTree<Integer, Integer> avl = new AVLTree<>();
        for (Integer x : testData)
            avl.add(x, null);

        endTime = System.nanoTime();

        time = (endTime - startTime) / 1000000000.0;
        System.out.println("AVL: " + time + " s");


        // Test RBTree
        startTime = System.nanoTime();

        RBTree<Integer, Integer> rbt = new RBTree<>();
        for (Integer x : testData)
            rbt.add(x, null);

        endTime = System.nanoTime();

        time = (endTime - startTime) / 1000000000.0;
        System.out.println("RBTree: " + time + " s");
    }
}
/*
 * 测试结果：
 *      BST: 62.632079551 s
 *      AVL: 63.976831979 s
 *      RBTree: 63.737420078 s
 */

