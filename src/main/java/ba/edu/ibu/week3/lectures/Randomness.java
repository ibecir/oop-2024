package ba.edu.ibu.week3.lectures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

class Randomness {
    public static void main(String[] args) {
        Random randomizer = new Random(); // creates a random number generator
        int i = 0;

        while (i < 10) {
            // Generates and prints out a new random number on each round of the loop
            System.out.println(randomizer.nextInt(10));
            i++;
        }
    }
}

class WeatherForecaster {
    private Random random;

    public WeatherForecaster() {
        this.random = new Random();
    }
    public String forecastWeather() {
        double probability = this.random.nextDouble();
        if (probability <= 0.1)
            return "Sleet";
        else if (probability <= 0.4)// 0.1 + 0.3
            return "Snow";
        else // the rest, 1.0 - 0.4 = 0.6
            return "Sunny";
    }
    public int forecastTemperature() {
        return (int) (4 * this.random.nextGaussian() - 3);
    }
}
class Program {
    public static void main(String[] args) {
        WeatherForecaster forecaster = new WeatherForecaster();

        ArrayList<String> days = new ArrayList<String>();
        Collections.addAll(days, "Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun");

        System.out.println("Weather forecast for the next week:");
        for(String day : days) {
            String weatherForecast = forecaster.forecastWeather();
            int temperatureForecast = forecaster.forecastTemperature();

            System.out.println(day + ": " + weatherForecast + " " + temperatureForecast + " degrees.");
        }
    }
}



