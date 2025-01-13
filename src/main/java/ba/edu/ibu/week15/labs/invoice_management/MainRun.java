package ba.edu.ibu.week15.labs.invoice_management;

import java.util.List;

public class MainRun {
    public static void main(String[] args) {
        String inputFileName = "invoices.csv";
        String outputFileName = "report.csv";

        List<Invoice> invoices = InvoiceProcessor.loadInvoices(inputFileName);
        CSVReportGenerator.generateReport(outputFileName, invoices);

        System.out.println("Report generated: " + outputFileName);
    }
}
