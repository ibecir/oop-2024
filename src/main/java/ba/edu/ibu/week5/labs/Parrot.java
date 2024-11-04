package ba.edu.ibu.week5.labs;

public class Parrot extends Animal implements Speakable {

    public Parrot(String name) {
        super(name);
    }

    public Parrot(String name, int age, int health) {
        super(name, age, health);
    }

    @Override
    public String speak() {
        return getName() + " says Hello!";
    }

    @Override
    public String describe() {
        return getName() + " is a parrot, age: " + getAge() + ", health: " + getHealth() +
                ", remaining lifespan: " + calculateRemainingLifespan();
    }

    @Override
    public int expectedLifespan() {
        return 50;
    }

    public void fly(int distance) {
        health = Math.max(0, health - distance);
        if (health < 30) {
            age += 1;
        }
    }
}
