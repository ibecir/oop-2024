package ba.edu.ibu.week11.lectures.livesessions.firstgroup;

import java.security.InvalidParameterException;

class CustomExceptions {
    public static void main(String[] args) {
        int age = -1;

        if(age < 0 || age > 130){
            throw new InvalidAgeParameterException(new RuntimeException());
        }

        System.out.println("Good");
    }
}

class InvalidAgeParameterException extends RuntimeException{
    public InvalidAgeParameterException(String message){
        super(message);
    }
    public InvalidAgeParameterException(String message, Throwable cause){
        super(message, cause);
    }
    public InvalidAgeParameterException(Throwable cause){
        super(cause);
    }
}
