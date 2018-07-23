package _08_Trie_Using_HashMap_and_Array;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

/**
 * 文件相关操作
 *
 * @author cheng
 *         2018/5/12 14:36
 */
public class FileOperation {

    /**
     * 读取文件名为 filename 中的内容，并将其中包含的所有词汇放进 words 中
     *
     * @param filename
     * @param words
     * @return
     */
    public static boolean readFile(String filename, ArrayList<String> words) {

        if (filename == null || words == null) {
            System.out.println("filename is null or words is null.");
            return false;
        }

        // 文件读取
        Scanner scanner;
        try {
            File file = new File(filename);
            if (file.exists()) {
                FileInputStream fis = new FileInputStream(file);
                scanner = new Scanner(new BufferedInputStream(fis), "UTF-8");
                scanner.useLocale(Locale.ENGLISH);
            } else {
                System.out.println("File does not exist.");
                return false;
            }
        } catch (IOException e) {
            System.out.println("Cannot open " + filename + ".");
            return false;
        }

        // 简单分词（只能用于 demo 展示用）
        if (scanner.hasNextLine()) {
            String contents = scanner.useDelimiter("\\A").next();

            int start = firstCharacterIndex(contents, 0);
            for (int i = start + 1; i < contents.length(); ) {
                if (i == contents.length() || !isEnglishLetter(contents.charAt(i))) {

                    String word = contents.substring(start, i).toLowerCase();
                    words.add(word);
                    start = firstCharacterIndex(contents, i);
                    i = start + 1;
                } else {
                    i++;
                }
            }
        }

        return true;
    }

    /**
     * 寻找字符串s中，从start的位置开始的第一个字母字符的位置
     *
     * @param str
     * @param start
     * @return
     */
    private static int firstCharacterIndex(String str, int start) {

        for (int i = start; i < str.length(); i++) {
            if (isEnglishLetter(str.charAt(i))) {
                return i;
            }
        }
        return str.length();
    }

    private static boolean isEnglishLetter(char ch) {
        return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z');
    }
}
