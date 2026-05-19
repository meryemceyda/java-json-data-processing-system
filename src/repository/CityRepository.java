package repository;

import model.City;
import model.WeatherState;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import iterator.CityWeatherIterator;
import iterator.CloudyCityIterator;
import iterator.RainyCityIterator;
import iterator.SnowyCityIterator;
import iterator.SunnyCityIterator;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class CityRepository {

    private static CityRepository instance;
    private List<City> cities;

    private CityRepository() {
        cities = loadCitiesFromJson();
    }

    public static CityRepository getInstance() {
        if (instance == null) {
            instance = new CityRepository();
        }
        return instance;
    }

    public List<City> getCities() {
        return cities;
    }


    public CityWeatherIterator createWeatherIterator(WeatherState weatherState) {
        switch (weatherState) {
            case SUNNY:
                return new SunnyCityIterator(cities);
            case CLOUDY:
                return new CloudyCityIterator(cities);
            case RAINY:
                return new RainyCityIterator(cities);
            case SNOWY:
                return new SnowyCityIterator(cities);
            default:
                return null;
        }
    }

    private List<City> loadCitiesFromJson() {
        try {
            Gson gson = new Gson();

            InputStream inputStream = getClass()
                    .getClassLoader()
                    .getResourceAsStream("cities.json");

            if (inputStream == null) {
                System.out.println("cities.json bulunamadi!");
                return new ArrayList<>();
            }

            Reader reader = new InputStreamReader(inputStream);

            Type cityListType = new TypeToken<List<City>>() {}.getType();
            List<City> loadedCities = gson.fromJson(reader, cityListType);

            reader.close();

            if (loadedCities == null) {
                return new ArrayList<>();
            }

            return loadedCities;

        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}