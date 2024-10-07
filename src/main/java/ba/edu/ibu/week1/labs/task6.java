package ba.edu.ibu.week1.labs;

import java.util.Scanner;

public class task6 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println("Type the first integer: ");
        int firstNumber = Integer.parseInt(reader.nextLine());
        System.out.println("Type the second integer: ");
        int secondNumber = Integer.parseInt(reader.nextLine());

        if (firstNumber == secondNumber) {
            System.out.println("Equal numbers");
        } else if (firstNumber > secondNumber) {
            System.out.println("First number is greater");
        } else {
            System.out.println("Second number is greater");
        }
    }
}
