package org.example;

import java.io.Serializable;

public class Engine implements Serializable {

    private String name;
    private int horsepower;
    private double volume;

    public Engine(String name, int horsepower, double volume) {
        this.name = name;
        this.horsepower = horsepower;
        this.volume = volume;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Engine{" +
                "name='" + name + '\'' +
                ", horsepower=" + horsepower +
                ", volume=" + volume +
                '}';
    }
}
