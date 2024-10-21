package ba.edu.ibu.week3.lectures.livesession.secondgroup;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> students = new ArrayList<>();
        students.add("Eldar");
        students.add("Becir");
        students.add("Azra is Sveske");
        students.add("Ray Rocks");

        System.out.println(students.size());

        if (students.contains("Ray Rocks")) {
            students.remove("Ray Rocks");
        }

        students.add("Ray Rocks Hard");

        System.out.println(students.get(students.size() - 1));

        for (int i = 0 ; i < students.size() ; i++) {
            System.out.println(students.get(i));
        }

        int j = 0;
        while (j < students.size()){
            System.out.println(students.get(j));
            j++;
        }

        for (String student : students) {  // for each loop
            System.out.println(student);
        }

        System.out.println("--------------------------------------");

        Collections.sort(students);
        Collections.reverse(students);
        Collections.shuffle(students);
        for (String student : students) {  // for each loop
            System.out.println(student);
        }

        ArrayList<String> descendants = descendArrayList(students);
        for (String descendant : descendants) {
            System.out.println(descendant);
        }

        // Same as ArrayList<Integer> numbers
        List<Double> numbers = new ArrayList<>();
        numbers.add(3.0);
        numbers.add(1.1);
        numbers.add(2.2);
        numbers.add(3.2);

        numbers.remove(Double.valueOf(3.2));

        System.out.println(numbers);

        Random random = new Random();
        System.out.println(random.nextInt(100));

        Main main = new Main();
        main.removeMe(1);

        System.out.println(Gender.MALE);
        System.out.println(OrderStatus.DELIVERED);
    }

    public static ArrayList<String> descendArrayList(ArrayList<String> items){
        Collections.sort(items);
        Collections.reverse(items);

        return items;
    }

    public void removeMe(int i){

    }

    public void removeMe(int i, int j){

    }
}
