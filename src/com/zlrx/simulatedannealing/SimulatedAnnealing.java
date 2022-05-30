package com.zlrx.simulatedannealing;

public class SimulatedAnnealing {

    private double temperature = Main.START_TEMPERATURE;

    private Tour approximatedSolution;

    private int rounds = 0;

    public SimulatedAnnealing() {
        approximatedSolution = Tour.randomTourInstance();
    }

    public void simulation() {
        System.out.println("Initial solution: " + approximatedSolution.getTourDistance() + " km");
        long start = System.currentTimeMillis();
        Tour currentSolution = approximatedSolution;
        while (temperature > 1) {
            Tour newSolution = Tour.swappedCityInstance(currentSolution);

            double currentEnergy = currentSolution.getTourDistance();
            double newEnergy = newSolution.getTourDistance();

            //TODO lets see what happen if we remove this
            if (acceptanceProbability(currentEnergy, newEnergy, temperature) > Math.random()) {
                currentSolution = newSolution;
            }

            if (currentSolution.getTourDistance() < approximatedSolution.getTourDistance()) {
                approximatedSolution = currentSolution;
            }

            double coolingRate = Main.START_COOLING_RATE;
            temperature *= 1 - coolingRate;
            rounds++;
        }
        long end = System.currentTimeMillis();
        System.out.println("Best approximated solution: " + approximatedSolution.getTourDistance() + " km");
        System.out.println("Round count: " + rounds);
        System.out.println("Elapsed time: " + (end - start) + " ms");
    }

    private double acceptanceProbability(double currentEnergy, double newEnergy, double temperature) {
        if (currentEnergy > newEnergy) {
            return 100;
        }
        return Math.exp((currentEnergy - newEnergy) / temperature);
    }

}
