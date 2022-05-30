package com.zlrx.metaheuristic.randomsolution;

import com.zlrx.metaheuristic.Tour;

public class RandomSolution {

    private Tour bestSolution;

    private int rounds = 0;

    public RandomSolution() {
        bestSolution = Tour.randomTourInstance();
    }

    public void simulation() {
        System.out.println("Initial solution: " + bestSolution.getTourDistance() + " km");
        long start = System.currentTimeMillis();
        while (rounds < Main.ROUNDS) {
            Tour newSolution = Tour.randomTourInstance();
            if (newSolution.getTourDistance() < bestSolution.getTourDistance()) {
                bestSolution = newSolution;
            }
            rounds++;
        }
        long end = System.currentTimeMillis();
        System.out.println("Best random solution: " + bestSolution.getTourDistance() + " km");
        System.out.println("Elapsed time: " + (end - start) + " ms");
    }

}
