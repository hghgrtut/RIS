package org.example;

import java.io.Serializable;

public class Region implements Serializable {
    private String name;
    private double area;
    private int numberInhabitant;
    private int numberHouse;

    public Region(String name, double area, int numberInhabitant, int numberHouse) {
        this.name = name;
        this.area = area;
        this.numberInhabitant = numberInhabitant;
        this.numberHouse = numberHouse;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public int getNumberInhabitant() {
        return numberInhabitant;
    }

    public void setNumberInhabitant(int numberInhabitant) {
        this.numberInhabitant = numberInhabitant;
    }

    public int getNumberHouse() {
        return numberHouse;
    }

    public void setNumberHouse(int numberHouse) {
        this.numberHouse = numberHouse;
    }

    @Override
    public String toString() {
        return "Region{" +
                "name='" + name + '\'' +
                ", area=" + area +
                ", numberInhabitant=" + numberInhabitant +
                ", numberHouse=" + numberHouse +
                '}';
    }
}
