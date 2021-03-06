package com.zlrx.metaheuristic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Tour {

    private List<City> tour;
    private double distance;

    public static Tour randomTourInstance() {
        return new Tour();
    }

    public static Tour swappedCityInstance(Tour fromTour) {
        return new Tour(fromTour);
    }

    public static Tour swappedCityInstance(Tour fromTour,int a, int b){
        return new Tour(fromTour,a,b);
    }

    private Tour() {
        List<City> randomTour = new ArrayList<>(CityRepository.getInstance().getCities());
        Collections.shuffle(randomTour);
        tour = Collections.unmodifiableList(randomTour);
    }

    private Tour(Tour fromTour) {
        List<City> tourCopy = new ArrayList<>(fromTour.tour);
        int firstRnd = (int) (tourCopy.size() * Math.random());
        int secondRnd = (int) (tourCopy.size() * Math.random());
        swapTwoRandomCities(tourCopy,firstRnd,secondRnd);
        tour = Collections.unmodifiableList(tourCopy);
    }

    private Tour(Tour fromTour,int a, int b) {
        List<City> tourCopy = new ArrayList<>(fromTour.tour);
        swapTwoRandomCities(tourCopy,a,b);
        tour = Collections.unmodifiableList(tourCopy);
    }

    private void swapTwoRandomCities(List<City> tourCopy, int firstRnd, int secondRnd) {
        City tmp = tourCopy.get(firstRnd);
        tourCopy.set(firstRnd, tourCopy.get(secondRnd));
        tourCopy.set(secondRnd, tmp);
    }

    public double getTourDistance() {
        if (distance == 0) {
            for (int i = 0; i < tour.size(); ++i) {
                City from = tour.get(i);
                City to = (i + 1) < tour.size() ? tour.get(i + 1) : tour.get(0);
                distance += from.distanceTo(to);
            }
        }
        return distance;
    }

    public int size(){
        return tour.size();
    }

}
