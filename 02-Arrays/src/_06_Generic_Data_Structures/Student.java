package _06_Generic_Data_Structures;

import java.util.Objects;

/**
 * @author cheng
 *         2018/5/9 11:44
 */
public class Student {

    private String name;

    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Student student = (Student) o;
        return score == student.score && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, score);
    }

    @Override
    public String toString() {
        return String.format("Student(name: %s, score: %d)", name, score);
    }

    public static void main(String[] args) {

        Array<Student> arr1 = new Array<>();
        arr1.addLast(new Student("Alice", 100));
        arr1.addLast(new Student("Bob", 60));
        arr1.addLast(new Student("Arya", 30));
        System.out.println(arr1);

        Student[] students = {new Student("1", 1),
                new Student("2", 2),
                new Student("3", 3)};
        Array<Student> arr2 = new Array<>(students);
        System.out.println(arr2);
        arr2.removeElement(new Student("1", 1));
        System.out.println(arr2);
    }
}
