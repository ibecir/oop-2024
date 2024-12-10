package ba.edu.ibu.week11.lectures.livesessions.secondgroup;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.security.InvalidParameterException;

class InvalidAgeParameterException extends InvalidParameterException {
    public InvalidAgeParameterException(String message) {
        super(message);
    }
    public InvalidAgeParameterException(String message, Throwable cause) {
        super(message, cause);
    }
}

class Exceptions {
    public static void main(String[] args) {

        int age = -1;

        if(age < 0 || age > 140) {
            throw new InvalidAgeParameterException(
                    "Age has to be between 0 and 140",
                    new InvalidParameterException("Something went wrong")
            );
        }

        System.out.println(getNumber());

        try {
            System.out.println(Integer.parseInt("3"));
            readFile();
        } catch (FileNotFoundException e) {
            System.out.println("Error reading from file");
        } catch (NumberFormatException e) {
            System.out.println("Error parsing number");
        } finally {
            System.out.println("Sta god bilo ok je!");
        }
    }

    public static void readFile() throws FileNotFoundException {
        BufferedReader reader = new BufferedReader(
                new FileReader("becir.txt")
        );
    }

    public static int getNumber() {
        try {
            return 1;
        } catch (Exception e) {
            return 2;
        } finally {
            System.out.println("Ide ajdin na print");
            return 3;
        }
    }
}
