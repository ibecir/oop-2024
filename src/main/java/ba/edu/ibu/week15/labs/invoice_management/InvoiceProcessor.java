package ba.edu.ibu.week15.labs.invoice_management;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class InvoiceProcessor {
    public static List<Invoice> loadInvoices(String fileName) {
        List<Invoice> invoices = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            // Skip header
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");

                if (fields[0].isEmpty() || fields[1].isEmpty() || fields[5].isEmpty()) {
                    throw new InvalidInvoiceException("Missing required field", new ClassCastException());
                }

                Invoice.InvoiceBuilder builder = new Invoice.InvoiceBuilder()
                        .setInvoiceDate(sdf.parse(fields[0]))
                        .setInvoiceNumber(fields[1])
                        .setQtr(Integer.parseInt(fields[2]))
                        .setYear(Integer.parseInt(fields[3]))
                        .setCustomerName(fields[4])
                        .setTotalAmount(Double.parseDouble(fields[5]))
                        .setTaxAmount(Double.parseDouble(fields[6]))
                        .setNetAmount(Double.parseDouble(fields[7]));

                invoices.add(builder.build());
            }
        } catch (IOException | NumberFormatException | ParseException e) {
            throw new RuntimeException("Error loading invoices", e);
        }
        return invoices;
    }
}
