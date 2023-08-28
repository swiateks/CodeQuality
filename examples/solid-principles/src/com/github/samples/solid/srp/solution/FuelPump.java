package com.github.samples.solid.srp.solution;

/**
 * Created on 10-04-2016.
 */
public class FuelPump {

    public void reFuel(final Vehicle vehicle){
        final int remainingFuel = vehicle.getRemainingFuel();
        final int additionalFuel = vehicle.getMaxFuel() - remainingFuel;
        vehicle.setRemainingFuel(remainingFuel + additionalFuel);
    }
}
