package ba.edu.ibu.week7.lambdafunctions.classes;


import ba.edu.ibu.week7.lambdafunctions.interfaces.Printable;
import ba.edu.ibu.week7.lambdafunctions.interfaces.Readable;

public class Engine extends Component implements Readable, Printable {
    private int horsePower;

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    @Override
    public void read() {
        System.out.println("VRNNN");
    }

    @Override
    public String printMe(String prefix) {
        return prefix.concat(" IN THE ENGINE");
    }
}
