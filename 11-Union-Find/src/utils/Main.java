package utils;

import _02_Quick_Find.UnionFind1;
import _03_Quick_Union.UnionFind2;
import _04_Optimized_by_Size.UnionFind3;
import _05_Optimized_by_Rank.UnionFind4;
import _06_Path_Compression.UnionFind5;
import _07_More_about_Union_Find.UnionFind6;

import java.util.Random;

/**
 * @author cheng
 *         2018/5/17 14:27
 */
public class Main {

    private static double testUF(UF uf, int m) {

        int size = uf.getSize();
        Random random = new Random();

        long startTime = System.nanoTime();

        for (int i = 0; i < m; i++) {
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            uf.unionElements(a, b);
        }

        for (int i = 0; i < m; i++) {
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            uf.isConnected(a, b);
        }

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {

        int size = 10000000;
        int m = 10000000;

        UnionFind1 unionFind1 = new UnionFind1(size);
        // System.out.println("UnionFind1: " + testUF(unionFind1, m) + " s");

        UnionFind2 unionFind2 = new UnionFind2(size);
        // System.out.println("UnionFind2: " + testUF(unionFind2, m) + " s");

        UnionFind3 unionFind3 = new UnionFind3(size);
        System.out.println("UnionFind3: " + testUF(unionFind3, m) + " s");

        UnionFind4 unionFind4 = new UnionFind4(size);
        System.out.println("UnionFind4: " + testUF(unionFind4, m) + " s");

        UnionFind5 unionFind5 = new UnionFind5(size);
        System.out.println("UnionFind5: " + testUF(unionFind5, m) + " s");

        UnionFind6 unionFind6 = new UnionFind6(size);
        System.out.println("UnionFind6: " + testUF(unionFind6, m) + " s");
    }
}
