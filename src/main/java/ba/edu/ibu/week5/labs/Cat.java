package ba.edu.ibu.week5.labs;

public class Cat extends Animal implements Speakable {

    public Cat(String name) {
        super(name);
    }

    public Cat(String name, int age, int health) {
        super(name, age, health);
    }

    @Override
    public String speak() {
        return getName() + " meows!";
    }

    @Override
    public String describe() {
        return getName() + " is a cat, age: " + getAge() + ", health: " + getHealth() +
                ", remaining lifespan: " + calculateRemainingLifespan();
    }

    @Override
    public int expectedLifespan() {
        return 15;
    }

    public void hunt() {
        if (isHealthy()) {
            health = Math.min(100, health + 10);
        } else {
            health = Math.max(0, health - 20);
        }
    }
}
