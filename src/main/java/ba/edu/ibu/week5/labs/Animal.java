package ba.edu.ibu.week5.labs;

public abstract class Animal {
    private String name;
    protected int age;
    protected int health;

    public Animal(String name) {
        this(name, 0, 100);
    }

    public Animal(String name, int age, int health) {
        this.name = name;
        this.age = age;
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getHealth() {
        return health;
    }

    public boolean isHealthy() {
        return health > 70;
    }

    public void simulateYear() {
        age++;
        if (age > expectedLifespan() / 2) {
            health = Math.max(0, health - 5);
        }
    }

    public int calculateRemainingLifespan() {
        int lifespan = expectedLifespan();
        if (health < 50) {
            lifespan -= (50 - health) / 10;
        }
        return Math.max(0, lifespan - age);
    }

    public abstract String describe();

    public abstract int expectedLifespan();

    public void performSpecialAction(Animal animal) {
        if (animal instanceof Dog) {
            Dog dog = (Dog) animal;
            dog.interactWith(this instanceof Dog ? (Dog) this : null);
        } else if (animal instanceof Cat) {
            Cat cat = (Cat) animal;
            cat.hunt();
        } else if (animal instanceof Parrot) {
            Parrot parrot = (Parrot) animal;
            parrot.fly(10);
        }
    }
}
