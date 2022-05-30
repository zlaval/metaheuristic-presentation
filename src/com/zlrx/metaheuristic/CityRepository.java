package com.zlrx.metaheuristic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CityRepository {

    private final List<City> cities;

    private static class InstanceHolder {
        private static final CityRepository INSTANCE = new CityRepository();
    }

    public static CityRepository getInstance() {
        return InstanceHolder.INSTANCE;
    }

    private CityRepository() {
        List<City> generatedCities = new ArrayList<>();
        for (int i = 0; i < 100; ++i) {
            generatedCities.add(new City((int) (Math.random() * 100), (int) (Math.random() * 100)));
        }
        cities = Collections.unmodifiableList(generatedCities);
    }

    public List<City> getCities() {
        return cities;
    }

}
