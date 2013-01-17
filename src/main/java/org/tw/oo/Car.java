package org.tw.oo;

public class Car {
    private String status;

    public Car() {
        status = "Flameout";
    }

    public String getStatus() {
        return status;
    }

    public void start() {
        status = "StartUp";
    }

    public void accelerate() {
        status = status.equals("Flameout") ? "Flameout" : "Rotating";
    }

    public void stop() {
       status = "Flameout";
    }

    public void gearUp() {
       status = status.equals("Flameout") ? "Flameout" : "Geared";
    }
}
