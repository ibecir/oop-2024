package ba.edu.ibu.week4.lectures.livesession.secondgroup;

import java.util.ArrayList;

class GroupTwo {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("Ray");
        strings.add("Becir");
        strings.add("Faris");

        System.out.println(strings);

        removeFirstListElement(strings);
        System.out.println(strings);
    }

    public static void removeFirstListElement(ArrayList<String> whateveryouwantittobecalled) {
        whateveryouwantittobecalled.remove(0);
    }
}

class EldarSatara {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        numbers.add(4);
        numbers.add(3);
        numbers.add(7);
        numbers.add(3);

        String name = "Becir";
        String nametwo = new String("Eldar");

        System.out.println("The numbers in the beginning:");
        printListElements(numbers);

        numbers = removeListElementByValue(numbers, 3);

        System.out.println("The numbers after removal:");
        printListElements(numbers);
    }
    public static void printListElements(ArrayList<Integer> numbers){
        for (int number : numbers) {
            System.out.println(number);
        }
    }
    public static ArrayList<Integer> removeListElementByValue(ArrayList<Integer> numbers, int value){
        while (numbers.contains(Integer.valueOf(value))) {
            numbers.remove(Integer.valueOf(value));
        }
        return numbers;
    }
}

class Person {
    private String name;
    private int age;

    public Person(int age) {
        this.age = age;
    }

    public Person(String name, int age){
        this.name = name;
        this.age = age;
        System.out.println("I'm the main constructor with all attributes in class!");
    }
    public Person(String name){
        this.name = name;
        this.age = 0;

        System.out.println("One parameter constructor is called!");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

class Main {
    public static void main(String[] args) {
        Person becir = new Person("Becir", 30);
        Person eldar = new Person("Eldar", 20);
        Person sarah = new Person("Sarah");

        System.out.println(eldar.getName() + " " + eldar.getAge());
        System.out.println(becir.getName() + " " + becir.getAge());

        System.out.println(sarah.getName() + " " + sarah.getAge());
        sarah.setAge(20);
        System.out.println(sarah.getName() + " " + sarah.getAge());
    }
}

class Component {
    private String name;
    private int barCode;

    public Component(String name, int barCode) {
        this.name = name;
        this.barCode = barCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBarCode() {
        return barCode;
    }

    public void setBarCode(int barCode) {
        this.barCode = barCode;
    }

    public void sayWhoIAm(){
        System.out.println("I'm the component");
    }
}

class Engine extends Component {
    private int horsePower;
    private int motorSize;

    public Engine(String name, int barCode, int horsePower, int motorSize) {
        super(name, barCode); // set the value of the parent class attributes
        this.horsePower = horsePower;
        this.motorSize = motorSize;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public int getMotorSize() {
        return motorSize;
    }

    public void setMotorSize(int motorSize) {
        this.motorSize = motorSize;
    }

    public void sayWhoIAm(){
        System.out.println("I'm the engine");
    }

    public String toString(){
        return this.horsePower + " ----> " + this.motorSize;
    }
}

class GearBox extends Component {
    private int numberOfSpeeds;
    private GearboxType type;

    public GearBox(String name, int barCode, int numberOfSpeeds, GearboxType type) {
        super(name, barCode); // super points to the parent class
        this.numberOfSpeeds = numberOfSpeeds;
        this.type = type;
    }

    public int getNumberOfSpeeds() {
        return numberOfSpeeds;
    }

    public void setNumberOfSpeeds(int numberOfSpeeds) {
        this.numberOfSpeeds = numberOfSpeeds;
    }

    public GearboxType getType() {
        return type;
    }

    public void setType(GearboxType type) {
        this.type = type;
    }

    @Override
    public void sayWhoIAm(){
        System.out.println("I'm the gearbox");
    }

    @Override
    public String toString(){
        return this.numberOfSpeeds + " " + this.type;
    }
}

enum GearboxType {
    AUTOMATIC, MANUEL
}

class MainForInheritance {
    public static void main(String[] args) {
        Engine jedandevettdicrveno = new Engine("1.9 TDI", 34567, 100000, 1900);
        GearBox mjenjac = new GearBox("18 speeds", 4567, 18, GearboxType.MANUEL);
        Component component = new Component("Saraf", 45678);

        jedandevettdicrveno.sayWhoIAm();
        mjenjac.sayWhoIAm();
        component.sayWhoIAm();

        System.out.println(jedandevettdicrveno);
        System.out.println(component);
        System.out.println(mjenjac);
    }
}