package ba.edu.ibu.week13.labs.builder.staticNested;

public class Main {
    public static void main(String[] args) {
        CoffeeDirector director = new CoffeeDirector();

        Coffee espresso = director.constructCoffee(
                new Coffee.CoffeeBuilder()
                        .buildType(CoffeeType.ESPRESSO)
                        .buildSize(CoffeeSize.LARGE)
                        .addTopping(CoffeeToppings.CINNAMON)
        );

        Coffee latte = director.constructCoffee(
                new Coffee.CoffeeBuilder()
                        .buildType(CoffeeType.LATTE)
                        .buildSize(CoffeeSize.MEDIUM)
                        .addTopping(CoffeeToppings.MARSHMALLOW)
                        .addTopping(CoffeeToppings.WHIPPED_CREAM)
        );

        Coffee cappuccino = director.constructCoffee(
                new Coffee.CoffeeBuilder()
                        .buildType(CoffeeType.CAPPUCCINO)
                        .buildSize(CoffeeSize.SMALL)
                        .addTopping(CoffeeToppings.SALTED_CARAMEL)
                        .addTopping(CoffeeToppings.CHOCOLATE)
        );

        System.out.println(espresso);
        System.out.println(latte);
        System.out.println(cappuccino);
    }
}
