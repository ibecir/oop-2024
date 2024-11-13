package ba.edu.ibu.week7.livesession.firstgroup.finalkeyword;

class Animal {
    public final void saySomething(){
        System.out.println("Something");
    }
}

class Donkey extends Animal {
    // Not allowed
    //    @Override
    //    public void saySomething(){
    //        System.out.println("Something else");
    //    }
}

public class FinalKeyword {
    public static void main(String[] args) {
        final String MY_NAME;
        MY_NAME = "NijBecir";
    }
}
