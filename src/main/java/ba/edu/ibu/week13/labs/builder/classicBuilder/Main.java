package ba.edu.ibu.week13.labs.builder.classicBuilder;

import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        CoffeeDirector director = new CoffeeDirector();

        CoffeeBuilder espressoBuilder = new EspressoBuilder()
                .buildSize(CoffeeSize.SMALL)
                .buildToppings(Arrays.asList(CoffeeToppings.WHIPPED_CREAM));
        Coffee espresso = director.constructCoffee(espressoBuilder);
        System.out.println(espresso);

        CoffeeBuilder latteBuilder = new LatteBuilder()
                .buildSize(CoffeeSize.LARGE)
                .buildToppings(Arrays.asList(CoffeeToppings.SALTED_CARAMEL, CoffeeToppings.WHIPPED_CREAM));
        Coffee latte = director.constructCoffee(latteBuilder);
        System.out.println(latte);

        CoffeeBuilder cappuccinoBuilder = new CappuccinoBuilder()
                .buildSize(CoffeeSize.MEDIUM)
                .buildToppings(Collections.emptyList());
        Coffee cappuccino = director.constructCoffee(cappuccinoBuilder);
        System.out.println(cappuccino);
    }
}
