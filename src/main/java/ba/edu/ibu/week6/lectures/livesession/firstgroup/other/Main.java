package ba.edu.ibu.week6.lectures.livesession.firstgroup.other;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] numbers = {1,2,3,4};
        System.out.println(numbers.length);
        System.out.println(numbers[2]);

        Scanner reader = new Scanner(System.in);
        System.out.print("How many values? ");
        int amountOfValues = Integer.parseInt(reader.nextLine());

        int[] values = new int[amountOfValues];

        System.out.println("Enter values:");
        for(int i = 0; i < amountOfValues; i++) {
            String name = "Becir";
            values[i] = Integer.parseInt(reader.nextLine());
        }

        System.out.println("Values again:");
        for(int i = 0; i < amountOfValues; i++) {
            System.out.println(values[i]);
        }

    }
}
