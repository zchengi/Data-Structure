package _08_Trie_Using_HashMap_and_Array;

import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * 测试由 TreeSet，TreeMap，数组实现的 Trie 的性能
 *
 * @author cheng
 *         2018/7/23 20:54
 */
public class Main {

    public static void TestRunTime(String classname, ArrayList<String> words) {
        try {

            Class<?> clazz = Class.forName(classname);
            Object obj = clazz.newInstance();

            Method addMethod = clazz.getMethod("add", String.class);
            Method containsMethod = clazz.getMethod("contains", String.class);
            Method getSizeMethod = clazz.getMethod("getSize");

            long startTime = System.nanoTime();

            for (String word : words) {
                addMethod.invoke(obj, word);
            }

            for (String word : words) {
                containsMethod.invoke(obj, word);
            }

            long endTime = System.nanoTime();

            double time = (endTime - startTime) / 1000000000.0;

            System.out.println("Total different words: " + getSizeMethod.invoke(obj));
            System.out.println(clazz.getSimpleName() + ": " + time + " s");
            System.out.println();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        ArrayList<String> words = new ArrayList<>();
        FileOperation.readFile("10-Trie/src/txt/pride-and-prejudice.txt", words);
        FileOperation.readFile("10-Trie/src/txt/a-tale-of-two-cities.txt", words);

        // Test BST
        TestRunTime("_08_Trie_Using_HashMap_and_Array.BSTSet", words);

        // Test TreeMap Trie
        TestRunTime("_08_Trie_Using_HashMap_and_Array.Trie1", words);

        // Test HashMap Trie
        TestRunTime("_08_Trie_Using_HashMap_and_Array.Trie2", words);

        // Test Array(Map) Trie
        TestRunTime("_08_Trie_Using_HashMap_and_Array.Trie3", words);
    }
}
