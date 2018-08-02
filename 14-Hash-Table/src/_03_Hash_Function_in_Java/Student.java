package _03_Hash_Function_in_Java;

/**
 * @author cheng
 *         2018/8/2 13:08
 */
public class Student {

    private int grade;
    private int cls;
    private String firstName;
    private String lastName;

    public Student(int grade, int cls, String firstName, String lastName) {
        this.grade = grade;
        this.cls = cls;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object object) {

        if (this == object) return true;

        if (object == null||getClass() != object.getClass()) return false;

        Student another = (Student) object;

        return this.grade == another.grade
                && this.cls == another.cls
                && this.firstName.equalsIgnoreCase(another.firstName)
                && this.lastName.equalsIgnoreCase(another.lastName);
    }

    @Override
    public int hashCode() {

        int B = 31;

        int hash = 0;
        hash = hash * B + grade;
        hash = hash * B + cls;
        // 转换为小写字母，不区分大小写
        hash = hash * B + firstName.toLowerCase().hashCode();
        hash = hash * B + lastName.toLowerCase().hashCode();

        return hash;
    }

    @Override
    public String toString() {
        return "Student{" +
                "grade=" + grade +
                ", cls=" + cls +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getCls() {
        return cls;
    }

    public void setCls(int cls) {
        this.cls = cls;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
