package ba.edu.ibu.week13.labs.state;

public class RedLightState implements TrafficLightState{
    @Override
    public void transitionToRed() {
        System.out.println("Already in RED state");
    }

    @Override
    public void transitionToGreen() {
        System.out.println("Switching to GREEN state");
    }

    @Override
    public void transitionToYellow() {
        System.out.println("Switching to YELLOW state");
    }
}
