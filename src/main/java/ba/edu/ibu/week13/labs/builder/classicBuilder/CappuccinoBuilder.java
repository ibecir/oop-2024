package ba.edu.ibu.week13.labs.builder.classicBuilder;

import ba.edu.ibu.week13.labs.builder.classicBuilder.CoffeeSize;
import ba.edu.ibu.week13.labs.builder.classicBuilder.CoffeeToppings;

import java.util.List;

public class CappuccinoBuilder implements CoffeeBuilder {
    private Coffee coffee;

    public CappuccinoBuilder(){
        this.coffee = new Coffee();
        this.coffee.setType(CoffeeType.CAPPUCCINO);
    }
    @Override
    public CoffeeBuilder buildSize(CoffeeSize size) {
        this.coffee.setSize(size);
        return this;
    }

    @Override
    public CoffeeBuilder buildToppings(List<CoffeeToppings> toppings) {
        this.coffee.setToppings(toppings);
        return this;
    }

    @Override
    public Coffee build() {
        return this.coffee;
    }
}