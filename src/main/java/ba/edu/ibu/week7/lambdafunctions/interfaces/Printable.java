package ba.edu.ibu.week7.lambdafunctions.interfaces;

// Interfaces with one single method is called an FUNCTIONAL INTERFACE
// SAM interfaces - Single Abstract Method interface
// Lambdas can only be used in the sense of the Functional Interfaces
@FunctionalInterface
public interface Printable {
    public String printMe(String suffix); // Abstract method
}
