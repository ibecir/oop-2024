package ba.edu.ibu.week3.lectures.livesession.firstgroup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class MyStreams {
    private static List<Student> students = Arrays.asList(
            new Student("Becir", 30, Gender.MALE, "12345"),
            new Student("Edina", 21, Gender.FEMALE, "345678"),
            new Student("Aid", 22, Gender.MALE, "345678")
    );

    public static void main(String[] args) {
        List<Student> studentsList = getStudentsByGender(Gender.MALE);
        for (Student student : studentsList) {
            System.out.println(student.name);
        }

        Optional<Student> moreBitIma = getStudentByGender(Gender.MALE);
        if(moreBitIma.isEmpty()) {

        } else {

        }
    }

    public static List<Student> getStudentsByGender(Gender gender) {
        List<Student> tmp = new ArrayList<>();
        for (Student student : students) {
            if(student.gender == gender)
                tmp.add(student);
        }
        return tmp;
    }

    public static List<Student> getStudentsByGenderStream(Gender gender) {
        students
                .stream()
                .filter(student -> student.gender == gender)
                .toList();
        return students;
    }

    public static Optional<Student> getStudentByGender(Gender gender) {
        return students
                .stream()
                .filter(student -> student.gender == gender)
                .findFirst();
    }
}
