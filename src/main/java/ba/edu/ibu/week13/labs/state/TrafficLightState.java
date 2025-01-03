package ba.edu.ibu.week13.labs.state;

public interface TrafficLightState {
    void transitionToRed();
    void transitionToGreen();
    void transitionToYellow();
}
