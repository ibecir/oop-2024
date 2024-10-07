package ba.edu.ibu.week1.labs;

import java.util.Scanner;

public class task5 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println("Type an integer: ");
        int number = Integer.parseInt(reader.nextLine());
        if (number >= 0) {
            System.out.println("The number is positive");
        } else {
            System.out.println("The number is negative");
        }
    }
}
