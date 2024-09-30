package ba.edu.ibu.week5.lectures.polymorphism.typecasting;

class Animal {}

class Turtle extends Animal {}

class Tiger extends Animal {}

class Main {
    public static void main(String[] args) {
        Animal animal = new Tiger();
    }
}
