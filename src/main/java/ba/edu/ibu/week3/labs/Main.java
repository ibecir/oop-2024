package ba.edu.ibu.week3.labs;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        int number = 1;
        number = addThreeAndReturn(number);
        System.out.println(number);  // prints 4, because number has the return value
    }
    public static int addThreeAndReturn(int incremented) {
        incremented = incremented + 3;
        return incremented;
    }

    public static void removeFirst(ArrayList<Integer> list) {
        list.remove(0); // removes the number from index 0
    }

    public static void listOperations(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        numbers.add(4);
        numbers.add(3);
        numbers.add(7);
        numbers.add(3);

        System.out.println(numbers); // prints [4,3,7,3]

        removeFirst(numbers);

        System.out.println(numbers); // prints [3,7,3]
    }

}
