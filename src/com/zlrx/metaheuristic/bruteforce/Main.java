package com.zlrx.metaheuristic.bruteforce;

public class Main {

    public static final double ROUNDS = 10_000_000; //100k, 1m, 10m

    public static void main(String[] args) {
        var bruteforce=new BruteForce();
        bruteforce.simulation();
    }
}
