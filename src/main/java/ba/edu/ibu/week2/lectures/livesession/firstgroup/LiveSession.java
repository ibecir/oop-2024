package ba.edu.ibu.week2.lectures.livesession.firstgroup;

public class LiveSession {
    public static void main(String[] args) {
        printHalfTriangle(5);
    }

    public static void printHalfTriangle(int length) {
        for(int i = 1; i <= length; i++){
            for(int j = 0; j < i; j++){
                System.out.print(i + " ");
            }
            System.out.println();
        }
        printTriangle(10);
        System.out.println("Becir aga");
    }

    public static void printTriangle(int length) {
        for(int i = 1; i <= length; i++){
            for(int j = 0; j < i; j++){
                System.out.print(i + " ");
            }
        }
        printHalfTriangle(5);
    }
}
