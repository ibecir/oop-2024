package ba.edu.ibu.week7.livesession.secondgroup.finalkeyword;

import ba.edu.ibu.week3.lectures.db.DbConnect;

// Final classes cannot be extended
// class Animal  extends DbConnect {


class Animal  {
    void saySomething() {
        System.out.println("Meow");
    }
    final void sayOneMoreThing() {
        System.out.println("Aw aw aw");
    }
}

class Cat extends Animal {
    @Override
    void saySomething() {
        System.out.println("Aw Aw");
    }

    /*
    Final methods cannot be overridden
    @Override
    void sayOneMoreThing() {
        System.out.println("Aw aw aw");
    }
     */
}
