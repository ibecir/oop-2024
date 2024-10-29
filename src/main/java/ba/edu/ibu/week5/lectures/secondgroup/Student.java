package ba.edu.ibu.week5.lectures.secondgroup;

import ba.edu.ibu.week5.lectures.polymorphism.items.Item;

import java.awt.datatransfer.Transferable;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class MyCustomDate {
    private int day;
    private int month;
    private int year;

    public MyCustomDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString(){
        return this.day + "-" + this.month + "-" + this.year;
    }
}

class Student implements Attendable {
    private String name;
    private double weight;
    private double height;
    private int age;
    private MyCustomDate dateOfBirth;

    public Student(String name, double weight, double height, int age) {
        this.name = name;
        this.weight = weight;
        this.height = height;
        this.age = age;
    }

    public Student(String name, double weight, double height, int age, MyCustomDate dateOfBirth) {
        this.name = name;
        this.weight = weight;
        this.height = height;
        this.age = age;
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean olderThan(Student student){
        return this.age > student.getAge();
    }

    public MyCustomDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(MyCustomDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString(){
        return this.name + " " + this.dateOfBirth;
    }

    @Override
    public boolean equals(Object object){
        if(object == null)
            return false;

        if(object instanceof Student){
            Student student = (Student) object;
            if(this.name.equals(student.getName()) && this.age == student.getAge())
                return true;
        }

        return false;
    }

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Ray", 70, 175, 20, new MyCustomDate(28, 5, 2005)));
        students.add(new Student("Becir", 75, 180, 30, new MyCustomDate(25, 7, 1994)));
        students.add(new Student("Eldar Satara", 70, 180, 20));

        Student satara = new Student("Eldar Satara", 70, 180, 22);

        satara.equals(new Counter(1));

        if(students.contains(satara))
            System.out.println("Satara is here!");
        else
            System.out.println("Nema Satare");
    }

    @Override
    public void silent() {
        System.out.println("I'm silent");
    }

    @Override
    public String followTheAgenda() {
        return "Sto ce nam interfejs!";
    }

    @Override
    public void askQuestion(String question) {
        System.out.println("Student asks question!");
    }
}

class Employee implements Attendable{
    private String name;

    public Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void silent() {
        System.out.println("I'm employee and I will be silend");
    }

    @Override
    public String followTheAgenda() {
        return "I'm following the agenda";
    }

    @Override
    public void askQuestion(String question) {
        System.out.println("Some questions");
    }
}

class Counter {
    private int value;

    public Counter() {
        this(0);
    }

    public Counter(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void grow(){
        this.value++;
    }

    public Counter clone() {
        return new Counter(this.value);
    }

    @Override
    public boolean equals(Object object){
        if(object == null)
            return false;

        if(object instanceof Counter){
            Counter counter = (Counter) object;
            if(this.value == counter.getValue())
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Counter myCounter = new Counter();
        myCounter.grow();
        myCounter.grow();

        System.out.println(myCounter.getValue());
        Counter myNewCounter = myCounter.clone();
        System.out.println(myNewCounter.getValue());

        System.out.println(myCounter.equals(myCounter));
    }
}

interface Attendable {
    public void silent();
    public String followTheAgenda();
    public void askQuestion(String question);
}

interface Itemable {
    public String getBarcode();
}

class CD implements Itemable{
    private String name;

    public CD(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getBarcode() {
        return "CD";
    }
}

class Book implements Itemable {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String getBarcode() {
        return "BOOK";
    }
}

class MyMainClass {
    public static void main(String[] args) {

    }

    public Itemable generateNewItem() {
        Random generator = new Random();
        int num = generator.nextInt(2);
        if(num == 0)
            return new CD("Lipe cvatu");
        else
            return new Book("Fortress", "Mesa Selimovic");
    }
}