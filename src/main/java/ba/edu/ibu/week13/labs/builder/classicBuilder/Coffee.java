package ba.edu.ibu.week13.labs.builder.classicBuilder;

import ba.edu.ibu.week13.labs.builder.classicBuilder.CoffeeBuilder;
import ba.edu.ibu.week13.labs.builder.classicBuilder.CoffeeSize;
import ba.edu.ibu.week13.labs.builder.classicBuilder.CoffeeToppings;
import ba.edu.ibu.week13.labs.builder.classicBuilder.CoffeeType;

import java.util.ArrayList;
import java.util.List;

class Coffee {
    private CoffeeType type;
    private CoffeeSize size;
    private List<CoffeeToppings> toppings;

    Coffee() { // Without modifier is *package private*
        this.toppings = new ArrayList<>();
    }

    public void setType(CoffeeType type) {
        this.type = type;
    }

    public void setSize(CoffeeSize size) {
        this.size = size;
    }

    public void setToppings(List<CoffeeToppings> toppings) {
        this.toppings = toppings;
    }

    @Override
    public String toString() {
        return "Coffee{" +
                "type='" + type + '\'' +
                ", size='" + size + '\'' +
                ", toppings=" + toppings +
                '}';
    }
}
