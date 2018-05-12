package _01_Set_Basics_and_BSTSet;

import utils.FileOperation;

import java.util.ArrayList;

/**
 * @author cheng
 *         2018/5/12 14:46
 */
public class Main {
    public static void main(String[] args) {

        System.out.println("Pride and Prejudice");

        ArrayList<String> words1 = new ArrayList<>();
        if (FileOperation.readFile("07-Set-and-Map/src/txt/pride-and-prejudice.txt", words1)) {
            System.out.println("Total words: " + words1.size());

            BSTSet<String> set1 = new BSTSet<>();
            for (String word : words1) {
                set1.add(word);
            }
            System.out.println("Total different words: " + set1.getSize());
        }

        System.out.println();

        System.out.println("a-tale-of-two-cities");

        ArrayList<String> words2 = new ArrayList<>();
        if (FileOperation.readFile("07-Set-and-Map/src/txt/a-tale-of-two-cities.txt", words2)) {
            System.out.println("Total words: " + words2.size());

            BSTSet<String> set2 = new BSTSet<>();
            for (String word : words2) {
                set2.add(word);
            }
            System.out.println("Total different words: " + set2.getSize());
        }
    }
}
