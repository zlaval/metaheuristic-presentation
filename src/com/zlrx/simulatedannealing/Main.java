package com.zlrx.simulatedannealing;

public class Main {

    public static final double START_TEMPERATURE = 10_000;
    public static final double START_COOLING_RATE = 0.03; //6-7 zeros

    public static void main(String[] args) {
        var simulatedAnnealing = new SimulatedAnnealing();
        simulatedAnnealing.simulation();
    }

}
