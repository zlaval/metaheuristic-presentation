package com.zlrx.metaheuristic.randomsolution;

import com.zlrx.metaheuristic.simulatedannealing.SimulatedAnnealing;

public class Main {
    public static final double ROUNDS = 10_000; //100k, 1m, 10m

    public static void main(String[] args) {
        var randomSolution = new RandomSolution();
        randomSolution.simulation();
    }

}
