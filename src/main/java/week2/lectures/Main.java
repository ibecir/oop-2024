package week2.lectures;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public static void truthValues() {
        int num1 = 1;
        int num2 = 5;

        boolean firstGreater = true;

        if (num1 <= num2)
            firstGreater = false;

        if (!firstGreater) {  // means the same as firstGreater==false
            System.out.println("num1 was not greater");
        } else {
            System.out.println("num1 was greater");
        }
    }
}