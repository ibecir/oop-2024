package ba.edu.ibu.week15.labs.library;

import ba.edu.ibu.week15.labs.library.annotations.FieldValidation;
import ba.edu.ibu.week15.labs.library.enums.AvailabilityStatus;
import ba.edu.ibu.week15.labs.library.enums.BookCategory;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class LibraryReportGenerator {

    public static void generateReport(String outputFileName, List<Book> books) {
        if (books == null || books.isEmpty()) {
            System.out.println("No books to generate report.");
            return;
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFileName))) {
            // Write headers
            Field[] fields = Book.class.getDeclaredFields();
            StringBuilder header = new StringBuilder();
            for (int i = 0; i < fields.length; i++) {
                header.append(fields[i].getName().toUpperCase());
                if (i < fields.length - 1) {
                    header.append(",");
                }
            }
            bw.write(header.toString());
            bw.newLine();

            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

            for (Book book : books) {
                StringBuilder row = new StringBuilder();
                for (int i = 0; i < fields.length; i++) {
                    Field field = fields[i];
                    field.setAccessible(true);
                    Object value = field.get(book);
                    String transformedValue = "";

                    if (field.isAnnotationPresent(FieldValidation.class)) {
                        FieldValidation annotation = field.getAnnotation(FieldValidation.class);
                        BookCategory category = book.getCategory();

                        if (value instanceof String) {
                            String str = (String) value;
                            if (category == BookCategory.FICTION) {
                                transformedValue = str.toUpperCase();
                            } else if (category == BookCategory.NON_FICTION) {
                                transformedValue = str.toLowerCase();
                            } else if (category == BookCategory.SCIENCE || category == BookCategory.ARTS) {
                                transformedValue = capitalizeEachWord(str);
                            } else {
                                transformedValue = str;
                            }
                        } else if (value instanceof Double || value instanceof Integer || value instanceof Float) {
                            double num = ((Number) value).doubleValue();
                            if (field.getName().equalsIgnoreCase("price") && category == BookCategory.TECHNOLOGY) {
                                num = num * 0.9; // Apply 10% discount
                            }
                            transformedValue = String.format("%.2f", num);
                        } else if (value instanceof Date) {
                            transformedValue = sdf.format((Date) value);
                        } else if (value instanceof AvailabilityStatus) {
                            AvailabilityStatus status = (AvailabilityStatus) value;
                            switch (status) {
                                case AVAILABLE:
                                    transformedValue = "A";
                                    break;
                                case CHECKED_OUT:
                                    transformedValue = "C";
                                    break;
                                case RESERVED:
                                    transformedValue = "R";
                                    break;
                                case LOST:
                                    transformedValue = "L";
                                    break;
                                default:
                                    transformedValue = "";
                            }
                        } else {
                            transformedValue = value.toString();
                        }
                    } else {
                        transformedValue = value.toString();
                    }

                    row.append(transformedValue);
                    if (i < fields.length - 1) {
                        row.append(",");
                    }
                }
                bw.write(row.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Error writing report to file: " + outputFileName, e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Error accessing book fields during report generation", e);
        }
    }

    private static String capitalizeEachWord(String str) {
        if (str == null || str.isEmpty()) return str;
        String[] words = str.split("\\s+");
        StringBuilder capitalized = new StringBuilder();
        for(int i=0; i<words.length; i++) {
            String word = words[i];
            if(word.length() > 0){
                capitalized.append(Character.toUpperCase(word.charAt(0)));
                if(word.length() > 1){
                    capitalized.append(word.substring(1).toLowerCase());
                }
                if(i < words.length -1){
                    capitalized.append(" ");
                }
            }
        }
        return capitalized.toString();
    }
}