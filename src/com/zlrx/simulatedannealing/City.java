package com.zlrx.simulatedannealing;

public record City(int longitude,int latitude ) {

    public double distanceTo(City other) {
        double xDistance = Math.abs(longitude - other.longitude);
        double yDistance = Math.abs(latitude - other.latitude);
        return Math.sqrt(Math.pow(xDistance, 2) + Math.pow(yDistance, 2));
    }

}
