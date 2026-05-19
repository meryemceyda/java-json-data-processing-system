package ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import iterator.CityWeatherIterator;
import model.City;
import model.WeatherState;
import observer.ObserverMain;
import planner.PlannerMain;
import repository.CityRepository;
import strategy.CitySortStrategy;
import strategy.SortByAreaStrategy;
import strategy.SortByNameStrategy;
import strategy.SortByPopulationStrategy;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        
        while (true) {

            System.out.println("\n=== ANA MENU ===");
            System.out.println("1- Listeleme icin tur secin");
            System.out.println("2- Filtreleme icin tur secin");
            System.out.println("3- Observer uygulamasini calistir");
            System.out.println("4- Sehir aktivite planlayicisini calistir");
            System.out.println("Cikmak icin: Q");
            System.out.print("Seciminiz: ");

            String choice = scanner.nextLine().trim();

            if (choice.equalsIgnoreCase("Q")) {
                System.out.println("Programdan cikiliyor...");
                break;
            }

            switch (choice) {

                case "1":
                showSortingMenu(CityRepository.getInstance().getCities());
                break;

                case "2":
                    showFilteringMenu();
                    break;

                case "3":
                    ObserverMain.main(null);
                    break;

                case "4":
                    PlannerMain.main(null);
                    break;

                default:
                    System.out.println("Gecersiz secim yaptiniz.");
            }
        }
    }

    private static void showSortingMenu(List<City> cities) {

        System.out.println("\n=== SIRALAMA MENU ===");
        System.out.println("1- Isme gore siralama");
        System.out.println("2- Nufusa gore siralama");
        System.out.println("3- Yuzolcumune gore siralama");
        System.out.println("Cikmak icin: Q");
        System.out.print("Seciminiz: ");

        String choice = scanner.nextLine().trim();

        if (choice.equalsIgnoreCase("Q")) {
            return;
        }

        CitySortStrategy strategy = null;

        List<City> sortedCities = new ArrayList<>(cities);

        switch (choice) {

            case "1":
                strategy = new SortByNameStrategy();
                break;

            case "2":
                strategy = new SortByPopulationStrategy();
                break;

            case "3":
                strategy = new SortByAreaStrategy();
                break;

            default:
                System.out.println("Gecersiz secim yaptiniz.");
                return;
        }

        strategy.sort(sortedCities);

        System.out.println("\n--- Siralanmis Sehirler ---");

        for (City city : sortedCities) {
            System.out.println(city);
        }
    }

    private static void showFilteringMenu() {

        

        System.out.println("\n=== FILTRELEME MENU ===");
        System.out.println("1- Gunesli sehirler listesi");
        System.out.println("2- Bulutlu sehirler listesi");
        System.out.println("3- Yagmurlu sehirler listesi");
        System.out.println("4- Kar yagisli sehirler listesi");
        System.out.println("Cikmak icin: Q");
        System.out.print("Seciminiz: ");

        String choice = scanner.nextLine().trim();

        if (choice.equalsIgnoreCase("Q")) {
            return;
        }

        CityWeatherIterator iterator = null;

        switch (choice) {

            case "1":
                iterator = CityRepository
                        .getInstance()
                        .createWeatherIterator(WeatherState.SUNNY);
                break;

            case "2":
                iterator = CityRepository
                        .getInstance()
                        .createWeatherIterator(WeatherState.CLOUDY);
                break;

            case "3":
                iterator = CityRepository
                        .getInstance()
                        .createWeatherIterator(WeatherState.RAINY);
                break;

            case "4":
                iterator = CityRepository
                        .getInstance()
                        .createWeatherIterator(WeatherState.SNOWY);
                break;

            default:
                System.out.println("Gecersiz secim yaptiniz.");
                return;
        }

        System.out.println("\n--- Filtrelenmis Sehirler ---");

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}