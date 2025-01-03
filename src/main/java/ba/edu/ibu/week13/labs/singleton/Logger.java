package ba.edu.ibu.week13.labs.singleton;

public class Logger {
    private static Logger instance;
    private Logger() {}

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void log(String message) {
        System.out.println("Log: " + message);
    }

    public void logInfo(String message) {
        System.out.println("Info: " + message);
    }
    public void logWarning(String message) {
        System.out.println("Warning: " + message);
    }
    public void logError(String message) {
        System.out.println("Error: " + message);
    }

}
