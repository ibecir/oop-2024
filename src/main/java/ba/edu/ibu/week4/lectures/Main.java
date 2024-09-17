package ba.edu.ibu.week4.lectures;

import java.util.ArrayList;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        int number = 1;
        number = addThreeAndReturn(number);
        System.out.println(number);  // prints 4, because number has the return value

        Person becir = new Person("Becir");
        Person mirza = new Person("Mirza");

        becir.becomeOlder();
        becir.becomeOlder();

        mirza.becomeOlder();

        System.out.println("Age of Becir: " + becir.getAge());
        System.out.println("Age of Andrew: " + mirza.getAge());

        int total = becir.getAge() + mirza.getAge();

        System.out.println("Becir and Mirza are total of " + total + " years old");
    }

    public static void print(ArrayList<Integer> numbers) {
        for (int number : numbers) {
            System.out.println(number);
        }
    }

    public static void remove(ArrayList<Integer> numbers, int removed) {
        while (numbers.contains(Integer.valueOf(removed))) {
            numbers.remove(Integer.valueOf(removed));
        }
    }


    public static int addThreeAndReturn(int incremented) {
        incremented = incremented + 3;
        return incremented;
    }

    public static void removeFirst(ArrayList<Integer> list) {
        list.remove(0); // removes the number from index 0
    }

    public static void listOperations() {
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        numbers.add(4);
        numbers.add(3);
        numbers.add(7);
        numbers.add(3);

        System.out.println(numbers); // prints [4,3,7,3]

        removeFirst(numbers);

        System.out.println(numbers); // prints [3,7,3]
    }

    public static void objectsExample(String[] args) {
        ArrayList<String> cities = new ArrayList<String>();
        ArrayList<String> countries = new ArrayList<String>();
        countries.add("Finland");
        countries.add("Germany");
        countries.add("Netherlands");
        cities.add("Berliini");
        cities.add("Nijmegen");
        cities.add("Turku");
        cities.add("Helsinki");
        System.out.println("number of countries " + countries.size());
        System.out.println("number of cities " + cities.size());
        Scanner scanner = new Scanner(System.in);
    }

}

class Person {
    private String name;
    private int age;

    public Person(String nameAtStart) {
        this.age = 0;
        this.name = nameAtStart;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return this.name + ", age " + this.age + " years";
    }

    public void becomeOlder() {
        this.age++;    // same as this.age = this.age + 1;
    }

    public boolean isAdult() {
        return this.age >= 18;
    }
}





