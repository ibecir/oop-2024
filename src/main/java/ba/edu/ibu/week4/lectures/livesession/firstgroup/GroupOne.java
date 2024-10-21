package ba.edu.ibu.week4.lectures.livesession.firstgroup;

import javax.swing.text.html.parser.TagElement;
import java.lang.constant.ModuleDesc;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class GroupOne {
    public static void main(String[] args) {
        int number = 1;
        number = addThreeAndReturn(number);
        System.out.println(number);  // prints 4, because number has the return value

        listOperations();
    }

    public static int addThreeAndReturn(int becirnerazumijenista) {
        return becirnerazumijenista + 3;
    }

    public static void removeFirst(ArrayList<Integer> list) {
        list.remove(0); // removes the number from index 0
    }

    public static void listOperations() {
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        numbers.add(4);
        numbers.add(3);
        numbers.add(7);
        numbers.add(3);

        System.out.println(numbers); // prints [4,3,7,3]

        removeFirst(numbers);

        System.out.println(numbers); // prints [3,7,3]
    }
}

class GoodCode {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        numbers.add(4);
        numbers.add(3);
        numbers.add(7);
        numbers.add(3);

        System.out.println("The numbers in the beginning:");
        printList(numbers);

        removeAllOccurrencesOfThree(numbers);

        System.out.println("The numbers after removal:");
        printList(numbers);
    }

    public static void printList(ArrayList<Integer> numbers){
        for (int number : numbers)
            System.out.println(number);
    }

    public static void removeAllOccurrencesOfThree(ArrayList<Integer> numbers){
        while (numbers.contains(Integer.valueOf(3))) {
            numbers.remove(Integer.valueOf(3));
        }
    }
}

class Person {
    private String name;
    private int age;
    private String ucid;

    public Person(){
        // Meta programming in 9th week, it is hard, that is why i do not want to explain it now, you would be LOST!
    }

    public Person(int age, String ucid) {
        this.age = age;
        this.ucid = ucid;
    }

    public Person(String name, int age, String ucid){
        this.name = name;
        this.age = age;
        this.ucid = "N/A";
        System.out.println("ALL PARAMETERS");
    }
    public Person(String name, int age){
        this.name = name;
        this.age = age;
        this.ucid = "N/A";
        System.out.println("I'M THE BOSS, ONLY TWO PARAMS");
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

    public String getUcid() {
        return ucid;
    }

    public void setUcid(String ucid) {
        this.ucid = ucid;
    }

    public void setAge(int age){
        if(age < 0 || age > 200){
            System.out.println("You are a liar!");
            return;
        }
        this.age = age;
    }
    public void becomeOlder(){
        this.age = this.age + 1; // this.age++;
    }
    public String toString(){
        return "Name: " + this.name + ", Age: " + this.age;
    }
}

class Main {
    public static void main(String[] args) {
        Person becir = new Person("Becir", 30); // Create an instance
        Person aid = new Person("Aid", 21, "56789iouhsdbjn");
        System.out.println(becir);

        ArrayList<Integer> list = new ArrayList<>();
        Integer s = 3;

        System.out.println("###########################");

        Engin jedandevettdi = new Engin("1.9TDI crveno", 6632, 1999, 15000, 1900);
        jedandevettdi.printWhoIAm(); //

        SteeringWheel volan = new SteeringWheel("Volan", 1232, 12, "trokraki", Material.CARBON);
        volan.printWhoIAm(); //

        Component component = new Component("Component", 56789, 12);
        component.printWhoIAm(); //
    }
}

class Component {
    private String name;
    private int barCode;
    private int price;

    public Component(String name, int barCode, int price) {
        this.name = name;
        this.barCode = barCode;
        this.price = price;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void printWhoIAm(){
        System.out.println("I'm a component");
    }
}

class SteeringWheel extends Component{
    private String type;
    private Material material;

    public SteeringWheel(String name, int barCode, int price, String type, Material material){
        super(name, barCode, price); // Initialize a parent class attributes
        this.type = type;
        this.material = material;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }
}

class Engin extends Component{
    private int hp;
    private int size;

    public Engin(String name, int barCode, int price, int hp, int size){
        super(name, barCode, price); // constructor of the parent class
        this.hp = hp;
        this.size = size;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    @Override // annotation -> meta programming
    public void printWhoIAm(){
        System.out.println("I'm a engin");
    }

    @Override
    public String toString(){
        return this.getHp() + " - " + this.getSize();
    }
}

enum Material {
    LEATHER, CARBON
}
