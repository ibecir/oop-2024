package ba.edu.ibu.week7.livesession.firstgroup.optionals;

import java.util.Optional;

record Animal(String name){}

class Main {
    public static void main(String[] args) {
        Animal a = new Animal("Slon");
        Animal b = null;
        //System.out.println(b.name());

        Optional<Animal> myCat = getMeAnAnimal();

        if(b != null)
            System.out.println(b.name());

        if(myCat.isPresent())
            myCat.get().name();
    }

    public static Optional<Animal> getMeAnAnimal(){
        return Optional.ofNullable(null);
    }
}
