package week3.lectures;

import java.util.ArrayList;
import java.util.Collections;

class Main {
    public static void print(ArrayList<String> printed) {
        for (String word : printed) {
            System.out.println( word );
        }
    }

    public static void main(String[] args) {
        ArrayList<String> programmingLanguages = new ArrayList<String>();
        programmingLanguages.add("Java");
        programmingLanguages.add("Python");
        programmingLanguages.add("Ruby");
        programmingLanguages.add("C++");

        ArrayList<String> countries = new ArrayList<String>();
        countries.add("Finland");
        countries.add("Sweden");
        countries.add("Norway");

        print(programmingLanguages);//method is given the list programmingLanguages as a p
        print(countries);            //  method is given the list countries as a parameter

        ArrayList<Integer> numbers = addNumbersToList(3, 5, 2);

        for (int number : numbers)
            System.out.println( number );
    }

    public static void numberArrayListExample() {
        ArrayList<Double> doubles = new ArrayList<Double>();
        ArrayList<Character> characters = new ArrayList<Character>();

        ArrayList<Integer> numbers = new ArrayList<Integer>();
        numbers.add(4);
        numbers.add(8);
        // tries to remove the number from the index 4, does not work as expected!
        numbers.remove(4);

        // this removes the number 4 from the list
        numbers.remove(Integer.valueOf(4));
    }

    public static ArrayList<Integer> addNumbersToList(int num1, int num2, int num3){
        ArrayList<Integer> list = new ArrayList<Integer>();

        list.add(num1);
        list.add(num2);
        list.add(num3);

        return list;
    }
}

class ListProgram {
    public static void main(String[] args) {
        ArrayList<String> teachers = new ArrayList<String>();

        teachers.add("Anthony");
        teachers.add("Barto");
        teachers.add("Paul");

        ArrayList<String> shuffledObjects = shuffleExample(teachers);
        for (String teacher : shuffledObjects) {
            System.out.println(teacher);
        }
    }

    public static void searchExample() {
        ArrayList<String> teachers = new ArrayList<String>();

        teachers.add("Anthony");
        teachers.add("Barto");
        teachers.add("Paul");

        System.out.println("the number of teachers " + teachers.size());

        System.out.println("first teacher on the list " + teachers.get(0));
        System.out.println("third teacher on the list " + teachers.get(2));

        teachers.remove("Barto");

        if (teachers.contains("Barto")) {
            System.out.println("Barto is on the teachers list");
        } else {
            System.out.println("Barto is not on the teachers list");
        }
    }


    public static void example() {
        ArrayList<String> teachers = new ArrayList<String>();
        teachers.add("Anthony");
        teachers.add("Paul");
        teachers.add("John");
        teachers.add("Martin");
        teachers.add("Matt");
        int place = 0;
        while (place < teachers.size()) {  // remember why place <= doesn't work?
            System.out.println(teachers.get(place));
            place++;
        }
    }

    public static void iterationExample() {
        ArrayList<String> teachers = new ArrayList<String>();
        teachers.add("Anthony");
        teachers.add("Paul");
        teachers.add("John");
        teachers.add("Martin");
        teachers.add("Matt");
        for (String teacher : teachers) {
            System.out.println(teacher);
        }
    }

    public static void orderExample() {
        ArrayList<String> teachers = new ArrayList<String>();

        teachers.add("Paul");
        teachers.add("John");
        teachers.add("Anthony");

        Collections.sort(teachers);
        for (String teacher : teachers) {
            System.out.println(teacher);
        }
    }

    public static ArrayList<String> shuffleExample(ArrayList<String> objects) {
        Collections.shuffle(objects);
        return objects;
    }



}

