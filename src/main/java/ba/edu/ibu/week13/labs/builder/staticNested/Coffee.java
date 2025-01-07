package ba.edu.ibu.week13.labs.builder.staticNested;

import java.util.ArrayList;
import java.util.List;

class Coffee {
    private CoffeeType type;
    private CoffeeSize size;
    private List<CoffeeToppings> toppings;

    // Private constructor to enforce the use of builder
    private Coffee(CoffeeBuilder builder) {
        this.type = builder.type;
        this.size = builder.size;
        this.toppings = builder.toppings;
    }

    public static class CoffeeBuilder implements ba.edu.ibu.week13.labs.builder.staticNested.CoffeeBuilder {
        private CoffeeType type;
        private CoffeeSize size;
        private List<CoffeeToppings> toppings = new ArrayList<>();

        public CoffeeBuilder buildType(CoffeeType type) {
            this.type = type;
            return this;
        }

        public CoffeeBuilder buildSize(CoffeeSize size) {
            this.size = size;
            return this;
        }

        public CoffeeBuilder addTopping(CoffeeToppings topping) {
            this.toppings.add(topping);
            return this;
        }

        public Coffee build() {
            return new Coffee(this);
        }

        @Override
        public CoffeeBuilder buildType() {
            return null;
        }

        @Override
        public CoffeeBuilder buildSize() {
            return null;
        }

        @Override
        public CoffeeBuilder buildToppings() {
            return null;
        }
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
