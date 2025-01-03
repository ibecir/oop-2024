package ba.edu.ibu.week13.labs.state;

public class TrafficLightController {
    public static void main(String[] args) {
        TrafficLightContext context = new TrafficLightContext();

        context.transitionToGreen();
        context.transitionToYellow();
        context.transitionToRed();
        context.transitionToRed(); // Should stay in Red state
        context.transitionToGreen();
    }
}
