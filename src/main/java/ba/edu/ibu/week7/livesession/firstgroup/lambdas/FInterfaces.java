package ba.edu.ibu.week7.livesession.firstgroup.lambdas;

@FunctionalInterface
interface Printable {
    String print(String prefix, String suffix);
}

class Cat implements Printable {
    private String name;

    public Cat(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String print(String prefix, String suffix) {
        return "I'm a cat";
    }
}

class Main {
    public static void main(String[] args) {
       Printable myOwnCustomPrintable = (p, s) -> p + " something " + s;
        System.out.println(printPrintables(myOwnCustomPrintable));
    }

    public static String printPrintables(Printable thingToPrint){
        return thingToPrint.print("a", "b");
    }
}