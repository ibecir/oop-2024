package ba.edu.ibu.week10.labs.task2;


import java.util.Arrays;
import java.util.List;

public class Student {
    private String name;
    private int ID;
    private List<Integer> grades;

    public Student(String name, int ID, Integer[] grades){
        this.name = name;
        this.ID = ID;
        this.grades = Arrays.asList(grades);
    }

    public void printInfo(){
        System.out.print("Student ID: " + this.ID + ", name: " + this.name + ", ");
        System.out.print("Grades: ");
        for(Integer i : this.grades){
            System.out.print(i + " ");
        }
    }
}
