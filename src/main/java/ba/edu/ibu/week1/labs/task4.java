package ba.edu.ibu.week1.labs;

import java.util.Scanner;

public class task4 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println("Type the first integer: ");
        int firstNumber = Integer.parseInt(reader.nextLine());
        System.out.println("Type the second integer: ");
        int secondNumber = Integer.parseInt(reader.nextLine());
        System.out.println("The sum of numbers is " + (firstNumber + secondNumber));
    }
}
