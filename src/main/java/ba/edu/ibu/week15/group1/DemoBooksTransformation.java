package ba.edu.ibu.week15.group1;

import java.io.*;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

enum CaseFormatter {
    ORDINARY, LOWER_CASE, UPPER_CASE
}

enum NumberFormatter {
    COMMA, PERCENTAGE
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface WriteConcerns {
    CaseFormatter case_format() default CaseFormatter.ORDINARY;
    NumberFormatter number_format() default NumberFormatter.COMMA;
}

class MyBook {
    private Date date;
    @WriteConcerns(case_format = CaseFormatter.ORDINARY)
    private String quarter;
    private int quantity;
    private int year;
    @WriteConcerns(case_format = CaseFormatter.UPPER_CASE)
    private String customerId;
    @WriteConcerns(number_format = NumberFormatter.COMMA)
    private double totalAmount;
    @WriteConcerns(number_format = NumberFormatter.PERCENTAGE)
    private double profitPercentage;
    private double profitIncrease;
    private double costPrice;

    public MyBook(MyBookBuilder builder) {
        this.costPrice = builder.costPrice;
        this.customerId = builder.customerId;
        this.date = builder.date;
        this.profitIncrease = builder.profitIncrease;
        this.profitPercentage = builder.profitPercentage;
        this.quantity = builder.quantity;
        this.quarter = builder.quarter;
        this.totalAmount = builder.totalAmount;
        this.year = builder.year;
    }

    public static class MyBookBuilder {
        private Date date;
        private String quarter;
        private int quantity;
        private int year;
        private String customerId;
        private double totalAmount;
        private double profitPercentage;
        private double profitIncrease;
        private double costPrice;

        public MyBookBuilder() {

        }

        public MyBookBuilder setDate(Date date) {
            this.date = date;
            return this;
        }

        public MyBookBuilder setQuarter(String quarter) {
            this.quarter = quarter;
            return this;
        }

        public MyBookBuilder setCostPrice(double costPrice) {
            this.costPrice = costPrice;
            return this;
        }

        public MyBookBuilder setCustomerId(String customerId) {
            this.customerId = customerId;
            return this;
        }

        public MyBookBuilder setProfitIncrease(double profitIncrease) {
            this.profitIncrease = profitIncrease;
            return this;
        }

        public MyBookBuilder setProfitPercentage(double profitPercentage) {
            this.profitPercentage = profitPercentage;
            return this;
        }

        public MyBookBuilder setQuantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public MyBookBuilder setTotalAmount(double totalAmount) {
            this.totalAmount = totalAmount;
            return this;
        }

        public MyBookBuilder setYear(int year) {
            this.year = year;
            return this;
        }

        public MyBook build() {
            return new MyBook(this);
        }
    }

    public double getCostPrice() {
        return costPrice;
    }

    public String getCustomerId() {
        return customerId;
    }

    public Date getDate() {
        return date;
    }

    public double getProfitIncrease() {
        return profitIncrease;
    }

    public double getProfitPercentage() {
        return profitPercentage;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getQuarter() {
        return quarter;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public int getYear() {
        return year;
    }
}

class WrongFormatException extends RuntimeException {
    public WrongFormatException(String message){
        super(message);
    }

    public WrongFormatException(String message, Throwable cause){
        super(message, cause);
    }
}

class FirstGroupPrep {
    private List<MyBook> books = new ArrayList<>();

    public FirstGroupPrep(String filename) {
        this.books = loadBooks(filename);
    }

    public List<MyBook> getBooks() {
        return books;
    }

    public static List<MyBook> loadBooks(String filename) {
        List<MyBook> myBooks = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(
                    new FileReader(filename)
            );

            List<String> lines = reader.lines().collect(Collectors.toList());
            for (int i = 1; i < lines.size(); i++){
                String[] parts = lines.get(i).split(";");
                if(parts[0] == "" || parts[4] == "" || parts[5] == "")
                    throw new WrongFormatException("Values are empty", new ClassCastException());

                myBooks.add(
                        new MyBook.MyBookBuilder()
                                .setDate(new SimpleDateFormat("MM/dd/yyyy").parse(parts[0]))
                                .setQuarter(parts[1])
                                .setQuantity(Integer.parseInt(parts[2]))
                                .setYear(Integer.parseInt(parts[3]))
                                .setCustomerId(parts[4])
                                .setTotalAmount(Double.parseDouble(parts[5]))
                                .setProfitPercentage(Double.parseDouble(parts[6]))
                                .setProfitIncrease(Double.parseDouble(parts[7]))
                                .setCostPrice(Double.parseDouble(parts[8]))
                                .build()
                );
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (ParseException ee) {
            ee.printStackTrace();
        }
        return myBooks;
    }
}

class MyReportWriter {
    public static void writeReport(String outputFilename, List<MyBook> books){
        try {
            BufferedWriter writer = new BufferedWriter(
                    new FileWriter(outputFilename)
            );

            Class clazz = MyBook.class;
            Field[] fields = clazz.getDeclaredFields();

            for (int i = 0; i < fields.length; i++){
                writer.write(fields.length - 1 == i ?
                        fields[i].getName().concat("\n") :
                        fields[i].getName().concat(";")
                );
            }

            for (MyBook book : books){
                for (int i = 0; i < fields.length; i++){
                    fields[i].setAccessible(true);
                    if(fields[i].isAnnotationPresent(WriteConcerns.class)){
                        if(fields[i].get(book) instanceof String){
                            CaseFormatter caseFormat = fields[i].getAnnotation(WriteConcerns.class).case_format();

                            switch (caseFormat) {
                                case LOWER_CASE -> writer.write(
                                        fields.length - 1 == i ?
                                                fields[i].get(book).toString().toLowerCase().concat("\n") :
                                                fields[i].get(book).toString().toLowerCase().concat(";")
                                );

                                case UPPER_CASE -> writer.write(
                                        fields.length - 1 == i ?
                                                fields[i].get(book).toString().toUpperCase().concat("\n") :
                                                fields[i].get(book).toString().toUpperCase().concat(";")
                                );

                                case ORDINARY -> writer.write(
                                        fields.length - 1 == i ?
                                                fields[i].get(book).toString().concat("\n") :
                                                fields[i].get(book).toString().concat(";")
                                );
                            }
                        } else {
                            NumberFormatter numberFormat = fields[i].getAnnotation(WriteConcerns.class).number_format();

                            if(numberFormat == NumberFormatter.COMMA){
                                DecimalFormat df = new DecimalFormat("#,###.##");
                                writer.write(
                                        fields.length - 1 == i ?
                                                df.format(fields[i].get(book)).concat("\n") :
                                                df.format(fields[i].get(book)).concat(";")
                                );
                            } else {
                                writer.write(
                                        fields.length - 1 == i ?
                                                "%".concat(fields[i].get(book).toString()).concat("\n") :
                                                "%".concat(fields[i].get(book).toString()).concat(";")
                                );
                            }
                        }
                    } else {
                        writer.write(
                                fields.length - 1 == i ?
                                        fields[i].get(book).toString().concat("\n") :
                                        fields[i].get(book).toString().concat(";")
                        );
                    }
                }
            }

            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}

class DemoBooksTransformation {
    public static void main(String[] args) {
        FirstGroupPrep prep = new FirstGroupPrep("mybooks.csv");
        MyReportWriter writer = new MyReportWriter();
        writer.writeReport("tmp.csv", prep.getBooks());
    }
}
