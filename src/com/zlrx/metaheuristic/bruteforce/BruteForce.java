package com.zlrx.metaheuristic.bruteforce;

import com.zlrx.metaheuristic.Tour;

public class BruteForce {

    private Tour bestSolution;

    private int rounds = 0;

    public BruteForce() {
        bestSolution = Tour.randomTourInstance();
    }

    public void simulation() {
        System.out.println("Initial solution: " + bestSolution.getTourDistance() + " km");
        int[] indices = new int[bestSolution.size()];

        long start = System.currentTimeMillis();
        Tour currentTour = bestSolution;

        int i = 0;
        while (i < bestSolution.size() && rounds < Main.ROUNDS) {
            if (indices[i] < i) {
                var first = i % 2 == 0 ? 0 : indices[i];
                currentTour = Tour.swappedCityInstance(currentTour, first, i);
                checkSolution(currentTour);
                indices[i]++;
                i = 0;
            } else {
                indices[i] = 0;
                i++;
            }

            rounds++;
        }

        long end = System.currentTimeMillis();
        System.out.println("Best random solution: " + bestSolution.getTourDistance() + " km");
        System.out.println("Elapsed time: " + (end - start) + " ms");
    }

    private void checkSolution(Tour newSolution) {
        if (newSolution.getTourDistance() < bestSolution.getTourDistance()) {
            bestSolution = newSolution;
        }
    }
}
