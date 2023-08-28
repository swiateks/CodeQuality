package com.github.samples.solid.dip.violation;

/**
 * Created on 10-04-2016.
 */
public class RacingCar {

    private final int maxFuel;
    private int remainingFuel;
    private int power;

    public RacingCar(final int maxFuel) {
        this.maxFuel = maxFuel;
        remainingFuel = maxFuel;
    }

    public void accelerate(){
        power++;
        remainingFuel--;
    }

}