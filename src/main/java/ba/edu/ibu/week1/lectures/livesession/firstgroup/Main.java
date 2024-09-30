package ba.edu.ibu.week1.lectures.livesession.firstgroup;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        calculator();
    }

    public static void calculator() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Please enter your choice: sum/multiply/quit");
            String command = scanner.nextLine();

            if (command.equals("quit")) {
                System.out.println("Goodbye!");
                break;
            }

            if (command.equals("sum") || command.equals("multiply")) {
                System.out.println("Please enter the first number: ");
                int firstNumber = Integer.parseInt(scanner.nextLine());

                System.out.println("Please enter the second number: ");
                int secondNumber = Integer.parseInt(scanner.nextLine());

                if (command.equals("sum"))
                    System.out.println("Sum of provided numbers is " + (firstNumber + secondNumber));
                else System.out.println("Multiplication of provided numbers is " + (firstNumber * secondNumber));
            } else
                System.out.println("Invalid choice `" + command + "`. Please enter valid choice");
        }
    }
}
