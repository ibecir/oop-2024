package ba.edu.ibu.week13.labs.builder.classicBuilder;

import ba.edu.ibu.week13.labs.builder.classicBuilder.CoffeeSize;
import ba.edu.ibu.week13.labs.builder.classicBuilder.CoffeeToppings;
import ba.edu.ibu.week13.labs.builder.classicBuilder.CoffeeType;

import java.util.List;

public class LatteBuilder implements CoffeeBuilder {
    private Coffee coffee;

    public LatteBuilder(){
        this.coffee = new Coffee();
        this.coffee.setType(CoffeeType.LATTE); // set type in beginning
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
