package ba.edu.ibu.week13.labs.builder.classicBuilder;

import ba.edu.ibu.week13.labs.builder.classicBuilder.CoffeeSize;
import ba.edu.ibu.week13.labs.builder.classicBuilder.CoffeeToppings;

import java.util.List;

public interface CoffeeBuilder {
    CoffeeBuilder buildSize(CoffeeSize size);
    CoffeeBuilder buildToppings(List<CoffeeToppings> toppings);
    Coffee build();
}
