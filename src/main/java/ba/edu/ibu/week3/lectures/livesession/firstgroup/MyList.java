package ba.edu.ibu.week3.lectures.livesession.firstgroup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class MyList {
    public static void main(String[] args) {
        ArrayList<String> students = new ArrayList<String>();
        students.add("Becir Isakovic");
        students.add("Firstss Aid");
        students.add("Timso Iz Prve Klupe");
        students.add("Edina je Zmaj");

        Collections.sort(students);
        Collections.reverse(students);
        Collections.shuffle(students);

        for(String student : students) {
            System.out.println(student);
        }

        Random random = new Random();
        for(int i = 0; i < 10; i++) {
            System.out.println(random.nextDouble());
        }

        MyList becir = new MyList();

        becir.getAllStudents(students);
    }

    public ArrayList<String> getAllStudents(ArrayList<String> myList){
        return myList;
    }
}
