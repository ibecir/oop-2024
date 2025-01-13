package ba.edu.ibu.week15.labs.invoice_management;

import java.io.BufferedWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class CSVReportGenerator {
    public static void generateReport(String outputFileName, List<Invoice> invoices) {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(outputFileName))) {
            writer.write("InvoiceDate,InvoiceNumber,Qtr,Year,CustomerName,TotalAmount,TaxAmount,NetAmount\n");

            for (Invoice invoice : invoices) {
                StringBuilder line = new StringBuilder();

                for (Field field : invoice.getClass().getDeclaredFields()) {
                    field.setAccessible(true);

                    FieldFormat annotation = field.getAnnotation(FieldFormat.class);
                    Object value = field.get(invoice);

                    if (annotation != null) {
                        if (value instanceof String) {
                            TextFormat textFormat = annotation.text_format();
                            if (textFormat == TextFormat.CAPITALIZE) {
                                value = capitalize((String) value);
                            } else if (textFormat == TextFormat.LOWERCASE) {
                                value = ((String) value).toLowerCase();
                            }
                        } else if (value instanceof Double) {
                            CurrencyFormat currencyFormat = annotation.currency_format();
                            value = formatCurrency((Double) value, currencyFormat);
                        }
                    }

                    line.append(value).append(",");
                }
                writer.write(line.substring(0, line.length() - 1) + "\n");
            }
        } catch (IOException | IllegalAccessException e) {
            throw new RuntimeException("Error generating report", e);
        }
    }

    private static String capitalize(String input) {
        String[] words = input.split(" ");
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            result.append(word.substring(0, 1).toUpperCase()).append(word.substring(1).toLowerCase()).append(" ");
        }
        return result.toString().trim();
    }

    private static String formatCurrency(Double value, CurrencyFormat format) {
        switch (format) {
            case USD:
                return "$" + value;
            case EURO:
                return "€" + value;
            case INR:
                return "₹" + value;
            default:
                return value.toString();
        }
    }
}
