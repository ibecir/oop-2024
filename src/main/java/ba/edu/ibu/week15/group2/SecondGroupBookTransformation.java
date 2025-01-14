package ba.edu.ibu.week15.group2;

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

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface WriteConcerns {
    CaseFormatter case_format() default CaseFormatter.ORDINARY;

    NumberFormatter number_format() default NumberFormatter.COMMA;
}

class Book {
    private Date date;
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

    public Book(BookBuilder builder) {
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

    public static class BookBuilder {
        private Date date;
        private String quarter;
        private int quantity;
        private int year;
        private String customerId;
        private double totalAmount;
        private double profitPercentage;
        private double profitIncrease;
        private double costPrice;

        // Mandatory fields
        public BookBuilder() {
        }

        public BookBuilder setDate(Date date) {
            this.date = date;
            return this;
        }

        public BookBuilder setQuarter(String quarter) {
            this.quarter = quarter;
            return this;
        }

        public BookBuilder setCostPrice(double costPrice) {
            this.costPrice = costPrice;
            return this;
        }

        public BookBuilder setCustomerId(String customerId) {
            this.customerId = customerId;
            return this;
        }

        public BookBuilder setProfitIncrease(double profitIncrease) {
            this.profitIncrease = profitIncrease;
            return this;
        }

        public BookBuilder setProfitPercentage(double profitPercentage) {
            this.profitPercentage = profitPercentage;
            return this;
        }

        public BookBuilder setQuantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public BookBuilder setTotalAmount(double totalAmount) {
            this.totalAmount = totalAmount;
            return this;
        }

        public BookBuilder setYear(int year) {
            this.year = year;
            return this;
        }

        public Book build() {
            return new Book(this);
        }
    }
}

class WrongFormatException extends RuntimeException {
    public WrongFormatException(String message) {
        super(message);
    }

    public WrongFormatException(String message, Throwable cause) {
        super(message, cause);
    }
}

class FinalPrep {
    private List<Book> books;

    public FinalPrep(String filename) {
        this.books = loadBooks(filename);
    }

    public static List<Book> loadBooks(String filename) {
        List<Book> bookList = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(
                    new FileReader(filename)
            );

            List<String> lines = reader.lines().collect(Collectors.toList());

            for (int i = 1; i < lines.size(); i++) {
                String[] parts = lines.get(i).split(";");
                if(parts[0] == "" || parts[4] == "")
                    throw new WrongFormatException("Values are empty", new ClassCastException());
                bookList.add(
                        new Book.BookBuilder()
                                .setDate(new SimpleDateFormat("MM/dd/yyyy").parse(parts[0]))
                                .setQuarter(parts[1] == "" ? null : parts[1])
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
        } catch (ParseException pe) {
            pe.printStackTrace();
        }
        return bookList;
    }

    public List<Book> getBooks() {
        return this.books;
    }
}

class ReportWriter {
    public static void writeReport(String filename, List<Book> books) {
        Class clazz = Book.class;
        Field[] fields = clazz.getDeclaredFields();

        try {
            BufferedWriter writer = new BufferedWriter(
                    new FileWriter(filename)
            );

            for (int i = 0; i < fields.length; i++) {
                writer.write(i == fields.length - 1 ?
                        fields[i].getName().concat("\n") :
                        fields[i].getName().concat(";")
                );
            }

            for (Book book : books) {
                for (int i = 0; i < fields.length; i++) {
                    fields[i].setAccessible(true);
                    if (fields[i].isAnnotationPresent(WriteConcerns.class)) {
                        if (fields[i].get(book) instanceof String) {
                            CaseFormatter format = fields[i].getAnnotation(WriteConcerns.class).case_format();
                            switch (format) {
                                case UPPER_CASE -> writer.write(
                                        i == fields.length - 1 ?
                                                fields[i].get(book).toString().toUpperCase().concat("\n") :
                                                fields[i].get(book).toString().toUpperCase().concat(";")
                                );

                                case LOWER_CASE -> writer.write(
                                        i == fields.length - 1 ?
                                                fields[i].get(book).toString().toLowerCase().concat("\n") :
                                                fields[i].get(book).toString().toLowerCase().concat(";")
                                );

                                case ORDINARY -> writer.write(
                                        i == fields.length - 1 ?
                                                fields[i].get(book).toString().concat("\n") :
                                                fields[i].get(book).toString().concat(";")
                                );
                            }
                        } else {
                            NumberFormatter format = fields[i].getAnnotation(WriteConcerns.class).number_format();

                            if (format == NumberFormatter.COMMA) {
                                DecimalFormat df = new DecimalFormat("#,###.##");
                                writer.write(
                                        i == fields.length - 1 ?
                                                df.format(fields[i].get(book)).concat("\n") :
                                                df.format(fields[i].get(book)).concat(";")
                                );
                            } else {
                                writer.write(
                                        i == fields.length - 1 ?
                                                fields[i].get(book).toString().concat("%\n") :
                                                fields[i].get(book).toString().concat("%;")
                                );
                            }
                        }
                    } else {
                        writer.write(
                                i == fields.length - 1 ?
                                        fields[i].get(book).toString().concat("\n") :
                                        fields[i].get(book).toString().concat(";")
                        );
                    }
                }
            }

            writer.close();
        } catch (IOException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}

class SecondGroupBookTransformation {
    public static void main(String[] args) {
        FinalPrep prep = new FinalPrep("mybooks.csv");
        ReportWriter writer = new ReportWriter();
        writer.writeReport("tmp.csv", prep.getBooks());
    }
}
