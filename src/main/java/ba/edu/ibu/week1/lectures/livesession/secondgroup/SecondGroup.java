package ba.edu.ibu.week1.lectures.livesession.secondgroup;

import java.util.Scanner;

public class SecondGroup {
    public static void main(String[] args) {
        simpleCalculator();
    }
    public static void simpleCalculator(){
        while (true){
            System.out.println("Please choice one option: sum / multiply / quit");
            Scanner scanner = new Scanner(System.in);
            String command = scanner.nextLine();

            if(command.equals("quit"))
                break;

            if(command.equals("sum") || command.equals("multiply")){
                System.out.println("Please enter first number: ");
                int firstNumber = Integer.parseInt(scanner.nextLine());
                sayNesto();
                System.out.println("Please enter second number: ");
                int secondNumber = Integer.parseInt(scanner.nextLine());

                if(command.equals("sum"))
                    System.out.println("Sum of provided numbers is " + (firstNumber + secondNumber));
                else
                    System.out.println("Multiplication of provided numbers is " + (firstNumber * secondNumber));
            } else
                System.out.println("Invalid command `" + command + "`");
        }
    }
    public static void sayNesto() {
        System.out.println("Nesto");
    }
}
