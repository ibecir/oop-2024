package ba.edu.ibu.week15.labs.movie;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.lang.reflect.Field;
import java.text.DecimalFormat;
import java.util.List;

//Reporting
public class ReportWriter {
    public static void generateReport(String outputFileName, List<Movie> movies) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))) {
            Class<?> clazz = Movie.class;
            Field[] fields = clazz.getDeclaredFields();

            // Write header
            for (int i = 0; i < fields.length; i++) {
                writer.write(fields[i].getName().toUpperCase() + (i < fields.length - 1 ? "," : "\n"));
            }

            // Write movie data
            for (Movie movie : movies) {
                for (int i = 0; i < fields.length; i++) {
                    fields[i].setAccessible(true);

                    FieldFormat annotation = fields[i].getAnnotation(FieldFormat.class);
                    Object value = fields[i].get(movie);
                    String formattedValue = formatValue(value, annotation);

                    writer.write(formattedValue + (i < fields.length - 1 ? "," : "\n"));
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static String formatValue(Object value, FieldFormat annotation) {
        if (annotation == null || value == null) return value.toString();

        if (value instanceof String stringValue) {
            return switch (annotation.text_format()) {
                case UPPER_CASE -> stringValue.toUpperCase();
                case LOWER_CASE -> stringValue.toLowerCase();
                default -> stringValue;
            };
        } else if (value instanceof Double numberValue) {
            DecimalFormat df = annotation.number_format() == NumberFormatter.CURRENCY
                    ? new DecimalFormat("$#,###.##")
                    : new DecimalFormat("###.##%");
            return df.format(numberValue);
        }
        return value.toString();
    }
}
