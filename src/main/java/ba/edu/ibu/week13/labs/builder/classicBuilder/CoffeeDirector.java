package ba.edu.ibu.week13.labs.builder.classicBuilder;

public class CoffeeDirector {
    public Coffee constructCoffee(CoffeeBuilder builder) {
        return builder
                .build();
    }
}
