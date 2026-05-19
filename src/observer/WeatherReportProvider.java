package observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import model.City;
import model.WeatherState;

public class WeatherReportProvider extends Thread implements WeatherSubject {

    private List<City> cities;
    private List<WeatherObserver> observers;
    private Random random;
    private boolean running;

    public WeatherReportProvider(List<City> cities) {
        this.cities = cities;
        this.observers = new ArrayList<>();
        this.random = new Random();
        this.running = true;
    }

    @Override
    public void addObserver(WeatherObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(WeatherObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (WeatherObserver observer : observers) {
            observer.update(cities);
        }
    }

    @Override
    public void run() {
        while (running) {
            updateWeatherRandomly();
            notifyObservers();

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                running = false;
            }
        }
    }

    private void updateWeatherRandomly() {
        WeatherState[] states = WeatherState.values();

        for (City city : cities) {
            double randomTemperature = -5 + random.nextDouble() * 40;
            randomTemperature = Math.round(randomTemperature * 10.0) / 10.0;

            WeatherState randomState = states[random.nextInt(states.length)];

            city.setCurrentTemperature(randomTemperature);
            city.setCurrentWeatherState(randomState);
        }
    }

    public void stopProvider() {
        running = false;
        interrupt();
    }
}