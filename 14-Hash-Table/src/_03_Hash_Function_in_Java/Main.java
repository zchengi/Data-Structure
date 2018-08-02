package _03_Hash_Function_in_Java;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author cheng
 *         2018/8/2 13:09
 */
public class Main {
    public static void main(String[] args) {

        int a = 42;
        System.out.println(((Integer) a).hashCode());

        int b = -42;
        System.out.println(((Integer) b).hashCode());

        double c = 3.1415926;
        System.out.println(((Double) c).hashCode());

        String d = "cheng";
        System.out.println(d.hashCode());

        Student student = new Student(3, 2, "yu", "zhang");
        System.out.println(student.hashCode());

        HashSet<Student> set = new HashSet<>();
        set.add(student);

        HashMap<Student, Integer> scores = new HashMap<>();
        scores.put(student, 100);

        Student student2 = new Student(3, 2, "yu", "zhang");
        System.out.println(student2.hashCode());

    }
}
