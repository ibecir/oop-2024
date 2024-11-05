package ba.edu.ibu.week6.lectures.util;

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

    public String sayHello() {
        return "Animal";
    }
}

class Cat extends Animal {

    public Cat(String name) {
        super(name);
    }

    public String sayHello() {
        return "Cat";
    }
}

class Elephant extends Animal {
    public Elephant(String name) {
        super(name);
    }

    public String sayHello() {
        return "Elephant";
    }
}

class Slot<E extends Animal>{
    private E element;

    public Slot(E element) {
        this.element = element;
    }

    public E getElement(){
        return this.element;
    }

    public String whatWasSaid(){
        return element.sayHello();
    }

    public static void main(String[] args) {
        Slot<Cat> myIntegerSlot = new Slot<>(new Cat("Mici"));
        System.out.println(myIntegerSlot.whatWasSaid());

        Slot<Elephant> myStringSlot = new Slot<>(new Elephant("Slon"));
        System.out.println(myStringSlot.whatWasSaid());

        Slot<Animal> myAnimalSlot = new Slot<>(new Animal("Zivotinja"));
        System.out.println(myAnimalSlot.whatWasSaid());
    }
}

class HumanBeing {
    private String name;

    public HumanBeing(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}