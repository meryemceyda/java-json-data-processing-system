package planner;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import model.City;
import repository.CityRepository;

public class PlannerMain {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        List<City> cities = new ArrayList<>(CityRepository.getInstance().getCities());

        cities.sort(Comparator.comparing(City::getName));

        System.out.println("=== SEHIR AKTIVITE PLANLAYICI ===");
        System.out.println("Lutfen bir sehir seciniz:");

        for (int i = 0; i < cities.size(); i++) {
            System.out.println((i + 1) + "- " + cities.get(i).getName());
        }

        System.out.print("Seciminiz: ");
        int cityChoice = readInt();

        if (cityChoice < 1 || cityChoice > cities.size()) {
            System.out.println("Gecersiz sehir secimi.");
            return;
        }

        City selectedCity = cities.get(cityChoice - 1);
        CityPlanner planner = new BasicCityPlanner(selectedCity);

        while (true) {
            System.out.println("\n=== AKTIVITE MENU ===");
            System.out.println("1- Muze ziyareti ekle");
            System.out.println("2- Alisveris merkezi ziyareti ekle");
            System.out.println("3- Park ziyareti ekle");
            System.out.println("4- Sehir merkezi ziyareti ekle");
            System.out.println("5- Plani goster");
            System.out.println("Cikmak icin: Q");
            System.out.print("Seciminiz: ");

            String choice = scanner.nextLine().trim();

            if (choice.equalsIgnoreCase("Q")) {
                System.out.println("Programdan cikiliyor...");
                break;
            }

            switch (choice) {
                case "1":
                    planner = new MuseumVisitDecorator(planner);
                    System.out.println("Muze ziyareti eklendi.");
                    break;

                case "2":
                    planner = new ShoppingMallVisitDecorator(planner);
                    System.out.println("Alisveris merkezi ziyareti eklendi.");
                    break;

                case "3":
                    planner = new ParkVisitDecorator(planner);
                    System.out.println("Park ziyareti eklendi.");
                    break;

                case "4":
                    planner = new CityCenterVisitDecorator(planner);
                    System.out.println("Sehir merkezi ziyareti eklendi.");
                    break;

                case "5":
                    printPlan(planner);
                    break;

                default:
                    System.out.println("Gecersiz secim yaptiniz.");
            }
        }
    }

    private static int readInt() {
        try {
            int value = Integer.parseInt(scanner.nextLine().trim());
            return value;
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static void printPlan(CityPlanner planner) {
        System.out.println("\n--- OLUSTURULAN PLAN ---");
        System.out.println("Plan: " + planner.getDescription());
        System.out.println("Toplam maliyet: " + planner.getTotalCost() + " TL");
        System.out.println("Toplam sure: " + planner.getTotalTimeHours() + " saat");
    }
}