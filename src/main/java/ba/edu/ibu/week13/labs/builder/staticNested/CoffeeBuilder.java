package ba.edu.ibu.week13.labs.builder.staticNested;

public interface CoffeeBuilder {
    Coffee.CoffeeBuilder buildType();
    Coffee.CoffeeBuilder buildSize();
    Coffee.CoffeeBuilder buildToppings();
}
