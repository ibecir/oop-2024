package ba.edu.ibu.week10.labs.task3;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        Events e = new Events();
        e.generateEventsFile("events.txt", 6);
        Events.printEventsFromFile("events.txt");
        ArrayList<String> arr = Events.readEventsFromFile("events.txt");
        System.out.println(arr);
    }
}
