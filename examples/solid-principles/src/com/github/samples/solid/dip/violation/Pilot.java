package com.github.samples.solid.dip.violation;

/**
 * Created on 17-04-2016.
 */
public class Pilot {

    private RacingCar vehicle;

    public Pilot(){
        this.vehicle = new RacingCar(100);
    }

    public void increaseSpeed(){
        vehicle.accelerate();
    }
}
