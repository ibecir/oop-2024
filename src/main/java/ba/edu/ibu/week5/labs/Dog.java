package ba.edu.ibu.week5.labs;

public class Dog extends Animal implements Speakable {

    public Dog(String name) {
        super(name);
    }

    public Dog(String name, int age, int health) {
        super(name, age, health);
    }

    @Override
    public String speak() {
        return getName() + " barks!";
    }

    @Override
    public String describe() {
        return getName() + " is a dog, age: " + getAge() + ", health: " + getHealth() +
                ", remaining lifespan: " + calculateRemainingLifespan();
    }

    @Override
    public int expectedLifespan() {
        return 12;
    }

    public void interactWith(Dog anotherDog) {
        if (anotherDog != null) {
            if (this.isHealthy() && anotherDog.isHealthy()) {
                this.increaseHealth(10);
                anotherDog.increaseHealth(10);
            } else {
                this.decreaseHealth(5);
                anotherDog.decreaseHealth(5);
            }
        }
    }

    private void increaseHealth(int amount) {
        this.health = Math.min(100, this.health + amount);
    }

    private void decreaseHealth(int amount) {
        this.health = Math.max(0, this.health - amount);
    }
}

