package ba.edu.ibu.week7.livesession.secondgroup.functionalinterfaces;

@FunctionalInterface
interface Printable {
    void print();
}

class Cat implements Printable{
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
    public void print(){
        System.out.println("I'm a cat!");
    }
}

@FunctionalInterface
interface Operation {
    int performOperation(int x, int y);
}

class Main {
    public static void main(String[] args) {
        Cat cat = new Cat("Cicka micka");
        cat.print();

        Printable catPrintable = () -> {
            System.out.println("I'm a cat!");
        };
        printPrintables(cat);
        printPrintables(catPrintable);

        Operation add = (x, y) -> x + y;
        Operation multiply = (x, y) -> x * y;

        printOperation(1,2, add);
        printOperation(1,2, multiply);
    }

    public static void printOperation(int x, int y, Operation operation){
        System.out.println(operation.performOperation(x, y));
    }

    public static void printPrintables(Printable thing) {
        thing.print();
    }
}



