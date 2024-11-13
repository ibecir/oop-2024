package ba.edu.ibu.week7.livesession.firstgroup.recap;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

class IntegerPrinter {
    private Integer value;

    public IntegerPrinter(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public void print(){
        System.out.println(this.value);
    }
}
class DoublePrinter {
    private Double value;

    public DoublePrinter(Double value) {
        this.value = value;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public void print(){
        System.out.println(this.value);
    }
}

class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
class Elephant extends Animal {

    public Elephant(String name) {
        super(name);
    }
}
class Snake extends Animal {
    public Snake(String name) {
        super(name);
    }
}

class Printer<T> {
    private T value;

    public Printer(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void print() {
        System.out.println(this.value);
    }
}

class MainRun {
    public static void main(String[] args) {
        IntegerPrinter myPrinter = new IntegerPrinter(3);
        myPrinter.print();

        DoublePrinter mySecondPrinter = new DoublePrinter(1.3);
        mySecondPrinter.print();

        Printer<String> myStringPrinter = new Printer<>("Print something");
        myStringPrinter.print();

        Printer<Double> myDoublePrinter = new Printer<>(3.3);
        myDoublePrinter.print();

        List<Integer> myIntegerList = Arrays.asList(1,2,3,4,5);
        List<String> myStringList = Arrays.asList("Becir", "OOP");
        printMyLists(myIntegerList);
    }

    public static void printMyLists(List<? extends Object> objects){
        for (Object o : objects){
            System.out.println(o);
        }
    }

    public <T extends Animal, K> K printTheGeneric(T valueToPrinte, K anotherValueToPrint) {
        System.out.println(valueToPrinte);
        return anotherValueToPrint;
    }
}
