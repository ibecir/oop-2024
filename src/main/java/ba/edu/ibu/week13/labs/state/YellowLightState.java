package ba.edu.ibu.week13.labs.state;

public class YellowLightState implements TrafficLightState{
    @Override
    public void transitionToRed() {
        System.out.println("Switching to RED state");
    }

    @Override
    public void transitionToGreen() {
        System.out.println("Switching to GREEN state");
    }

    @Override
    public void transitionToYellow() {
        System.out.println("Already in YELLOW state");
    }
}
