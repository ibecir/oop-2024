package ba.edu.ibu.week11.lectures.livesessions.firstgroup;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Exceptions {
    public static void main(String[] args) {
        System.out.println(finallyExample());
        try {
            readFile();
            int a = Integer.parseInt("1");
        } catch (Exception e) {
            System.out.println("Exception happened");
        } finally {
            System.out.println("I'm always last to be executed");
        }
    }

    public static void readFile() throws FileNotFoundException {
        BufferedReader reader = new BufferedReader(
                new FileReader("/Users/becir/Documents/Academic Materials/IBU/2024-2025/FALL/Object Oriented Programming/Projects/oop-2024/src/main/java/ba/edu/ibu/week11/lectures/codingproblem/songs.csv")
        );
    }

    public static int finallyExample(){
        try {
            return 1;
        } catch (Exception e){
            return 2;
        } finally {
            return 3;
        }
    }

}
