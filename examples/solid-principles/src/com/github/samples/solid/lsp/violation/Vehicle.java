package com.github.samples.solid.lsp.violation;

/**
 * Created on 10-04-2016.
 */
public class Vehicle {

    private Gear gear;

    public Gear getGear() {
        return gear;
    }

    public void changeGear(final Gear gear) {
        this.gear = gear;
    }

}