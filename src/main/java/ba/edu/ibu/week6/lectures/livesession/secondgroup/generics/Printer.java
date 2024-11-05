package ba.edu.ibu.week6.lectures.livesession.secondgroup.generics;

import ba.edu.ibu.week4.labs.people.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

// The problem with having multiple class
class IntegerPrinter {
    private int value;

    public IntegerPrinter(int value) {
        this.value = value;
    }

    public void printValue() {
        System.out.println(this.value);
    }
}

class DoublePrinter {
    private double value;

    public DoublePrinter(double value) {
        this.value = value;
    }

    public void printValue() {
        System.out.println(this.value);
    }
}

class StringPrinter {
    private String value;

    public StringPrinter(String value) {
        this.value = value;
    }

    public void printValue() {
        System.out.println(this.value);
    }
}

// Solution by using the generics / templates
class Printer<T> {
    private T value;

    public Printer(T value) {
        this.value = value;
    }

    public void print() {
        System.out.println("Printing the thing " + value);
    }
}

class MultiPrinter<T, E> {
    private T value;
    private E aThing;

    public MultiPrinter(T value, E aThing) {
        this.value = value;
        this.aThing = aThing;
    }

    public void print() {
        System.out.println("Printing the multi thing " + value + " and " + aThing);
    }
}

class Student implements Comparable<Student> {
    private String name;
    private double gpa;

    public Student(String name, double gpa) {
        this.name = name;
        this.gpa = gpa;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public int compareTo(Student o) {
        if(this.gpa == o.getGpa())
            return 0;
        else if (this.gpa > o.getGpa())
            return 1;
        else
            return -1;
    }
}

interface Attendable<T extends Student> {
    void beSilent();
    void followTheLesson();
}

// Bounded generics
class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void eat() {
        System.out.println("Animal is eating");
    }
}
class Elephant extends Animal{
    public Elephant(String name) {
        super(name);
    }

    public void eat() {
        System.out.println("Elephant is eating");
    }
}
class Mouse extends Animal{
    public Mouse(String name) {
        super(name);
    }

    public void eat() {
        System.out.println("Mouse is eating");
    }
}

class BoundedPrinter<T extends Animal> {
    private T thing;

    public BoundedPrinter(T thing) {
        this.thing = thing;
    }
    // bounded generic
    public void printAnimalEatingHabits() {
        this.thing.eat();
    }
}




class Main {
    public static void main(String[] args) {
        Printer<String> stringPrinter = new Printer<>("OOP Course");
        Printer<Integer> integerPrinter = new Printer<>(34567);
        Printer<Double> doublePrinter = new Printer<>(34567.23);
        Printer<Person> personPrinter = new Printer<>(new Person("Becir", "IBU"));

        stringPrinter.print();
        integerPrinter.print();
        doublePrinter.print();
        personPrinter.print();

        BoundedPrinter<Elephant> personBoundedPrinter = new BoundedPrinter<>(new Elephant("MojSlonic"));
    }

    public <T, K> K genericPrinterNotBounded(T thingToPrint, K anotherThing){
        System.out.println(thingToPrint);
        return anotherThing;
    }

    // bounded generic method
    public <T extends Elephant> T genericPrinter(T thingToPrint){
        System.out.println(thingToPrint);
        return thingToPrint;
    }
}

class WildcardGenerics {
    public static void main(String[] args) {
        List<Object> animalList = new ArrayList<>();

        animalList.add(new Elephant("Slonic"));
        animalList.add(new Mouse("Misic"));
        animalList.add(new Person("Becir", "IBU"));

        //printTheAnimalsEating(animalList);

        List<Integer> integerList = Arrays.asList(1,2,3);
        // listOfIntegersIsNotListOfObjects(integerList); will not work

        HashMap<String, Animal> myHashMap = new HashMap<>();
        myHashMap.put("slonic", new Elephant("Slonic"));
        myHashMap.put("mouse", new Mouse("Misic"));

        hashMapWildcard(myHashMap);
    }

    // Mix
    public static <K> void hashMapWildcard(HashMap<K,?> myHasMap) {
        for (K key : myHasMap.keySet()){
            System.out.println(myHasMap.get(key));
        }
    }

    public static void listOfIntegersIsNotListOfObjects(List<Object> objectList) {
        for (Object object : objectList){
            Animal animal = (Animal) object;
            animal.eat();
        }
    }

    public static void wildcardPrinter(List<? extends Animal> myList){
        for (Animal object : myList){
            object.eat();
        }
    }

    public static void printTheAnimalsEating(List<Object> objectList) {
        for (Object object : objectList){
            Animal animal = (Animal) object;
            animal.eat();
        }
    }
}
