package observer;

import java.util.List;
import java.util.Scanner;

import model.City;
import repository.CityRepository;

public class ObserverMain {

    public static void main(String[] args) {
        List<City> cities = CityRepository.getInstance().getCities();

        WeatherReportProvider provider = new WeatherReportProvider(cities);

        WeatherObserver temperatureObserver = new TemperatureObserver();
        WeatherObserver weatherStateObserver = new WeatherStateObserver();

        provider.addObserver(temperatureObserver);
        provider.addObserver(weatherStateObserver);

        provider.start();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Observer uygulamasi baslatildi.");
        System.out.println("Hava durumu bilgileri her 5 saniyede bir guncellenecek.");
        System.out.println("Cikmak icin Q tusuna basiniz.");

        while (true) {
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("Q")) {
                provider.stopProvider();
                System.out.println("Observer uygulamasi sonlandiriliyor...");
                break;
            }
        }

   
    }
}