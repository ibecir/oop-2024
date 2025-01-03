package ba.edu.ibu.week13.labs.builder;

public class CoffeeDirector {
    public Coffee constructCoffee(Coffee.CoffeeBuilder builder) {
        return builder.build();
    }
}
