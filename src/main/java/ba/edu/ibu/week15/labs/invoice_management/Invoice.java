package ba.edu.ibu.week15.labs.invoice_management;

import java.util.Date;

public class Invoice {
    @FieldFormat
    private Date invoiceDate;

    @FieldFormat(text_format = TextFormat.CAPITALIZE)
    private String invoiceNumber;

    private int qtr;
    private int year;

    @FieldFormat(text_format = TextFormat.CAPITALIZE)
    private String customerName;

    @FieldFormat(currency_format = CurrencyFormat.USD)
    private double totalAmount;

    @FieldFormat(currency_format = CurrencyFormat.EURO)
    private double taxAmount;

    private double netAmount;

    private Invoice(InvoiceBuilder builder) {
        this.invoiceDate = builder.invoiceDate;
        this.invoiceNumber = builder.invoiceNumber;
        this.qtr = builder.qtr;
        this.year = builder.year;
        this.customerName = builder.customerName;
        this.totalAmount = builder.totalAmount;
        this.taxAmount = builder.taxAmount;
        this.netAmount = builder.netAmount;
    }

    public static class InvoiceBuilder {
        private Date invoiceDate;
        private String invoiceNumber;
        private int qtr;
        private int year;
        private String customerName;
        private double totalAmount;
        private double taxAmount;
        private double netAmount;

        public InvoiceBuilder setInvoiceDate(Date invoiceDate) {
            this.invoiceDate = invoiceDate;
            return this;
        }

        public InvoiceBuilder setInvoiceNumber(String invoiceNumber) {
            this.invoiceNumber = invoiceNumber;
            return this;
        }

        public InvoiceBuilder setQtr(int qtr) {
            this.qtr = qtr;
            return this;
        }

        public InvoiceBuilder setYear(int year) {
            this.year = year;
            return this;
        }

        public InvoiceBuilder setCustomerName(String customerName) {
            this.customerName = customerName;
            return this;
        }

        public InvoiceBuilder setTotalAmount(double totalAmount) {
            this.totalAmount = totalAmount;
            return this;
        }

        public InvoiceBuilder setTaxAmount(double taxAmount) {
            this.taxAmount = taxAmount;
            return this;
        }

        public InvoiceBuilder setNetAmount(double netAmount) {
            this.netAmount = netAmount;
            return this;
        }

        public Invoice build() {
            return new Invoice(this);
        }
    }

    public String toString() {
        return "Invoice{" +
                "invoiceDate=" + invoiceDate +
                ", invoiceNumber='" + invoiceNumber + '\'' +
                ", qtr=" + qtr +
                ", year=" + year +
                ", customerName='" + customerName + '\'' +
                ", totalAmount=" + totalAmount +
                ", taxAmount=" + taxAmount +
                ", netAmount=" + netAmount +
                '}';
    }
}
