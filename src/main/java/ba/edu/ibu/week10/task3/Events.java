package ba.edu.ibu.week10.task3;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class Events {

    private final String[] EVENT_TYPES = new String[]{"Login", "Logout", "Purchase", "ViewPage", "Error"};
    private final int RECORDS_NUMBER = 1000000;

    public void generateEventsFile(String fileName, int numOfRecords) throws IOException {

        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        Random random = new Random();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        for (int i = 0; i < numOfRecords; i++) {
            String timestamp = dateFormat.format(new Date(System.currentTimeMillis() - random.nextInt(1000000000)));
            String eventType = EVENT_TYPES[random.nextInt(EVENT_TYPES.length)];
            int userId = random.nextInt(1000);

            // Write the record to the file
            writer.write(timestamp + " | Event Type: " + eventType + " | User ID: " + userId);
            writer.newLine();
        }
        writer.close();
    }

    public static void printEventsFromFile(String fileName) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            System.out.println(); // Blank line between iterations
        }
    }

    public static ArrayList<String> readEventsFromFile(String fileName) throws IOException{
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            ArrayList<String> readLines = new ArrayList<>();
            while ((line = reader.readLine()) != null) {
                readLines.add(line);
            }
            return readLines;
        }
    }
}
