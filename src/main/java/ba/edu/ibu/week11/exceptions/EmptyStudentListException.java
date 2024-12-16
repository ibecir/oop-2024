package ba.edu.ibu.week11.exceptions;

public class EmptyStudentListException extends RuntimeException {
    public EmptyStudentListException(String message){
        super(message);
    }
}
