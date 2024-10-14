package ba.edu.ibu.week3.lectures.livesession.firstgroup;

public class Student {
    public String name;
    public int age;
    public Gender gender;
    public String ucid;

    public Student(String name, int age, Gender gender, String ucid) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.ucid = ucid;
    }

    public static void main(String[] args) {
        Student aid = new Student("Aid Ajkunic", 25, Gender.MALE, "2507994daljenema");
    }
}
