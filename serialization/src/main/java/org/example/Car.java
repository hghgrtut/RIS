package org.example;

import java.io.Serializable;
import java.rmi.Remote;

public class Car implements ICar, Serializable, Remote {

    private CarBrand brand;
    private String model;
    private BodyType bodyType;
    private int numberWheels;
    private  Engine engine;
    private double price;

    public Car(CarBrand brand) {
        this.brand = brand;
    }

    public Car(CarBrand carBrand, String model, BodyType bodyType, int numberWheels, Engine engine, double price) {
        this.brand = carBrand;
        this.model = model;
        this.bodyType = bodyType;
        this.numberWheels = numberWheels;
        this.engine = engine;
        this.price = price;
    }

    @Override
    public void start() {
        System.out.println("The" + this.brand + " " + this.model + "started");
    }

    @Override
    public void drive() {
        System.out.println("The" + this.brand + " " + this.model + "went");
    }

    @Override
    public void stop() {
        System.out.println("The" + this.brand + " " + this.model + "stopped");
    }

    public CarBrand getBrand() {
        return brand;
    }

    public void setBrand(CarBrand carBrand) {
        this.brand = carBrand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public BodyType getBodyType() {
        return bodyType;
    }

    public void setBodyType(BodyType bodyType) {
        this.bodyType = bodyType;
    }

    public int getNumberWheels() {
        return numberWheels;
    }

    public void setNumberWheels(int numberWheels) {
        this.numberWheels = numberWheels;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand=" + brand +
                ", model='" + model + '\'' +
                ", bodyType=" + bodyType +
                ", numberWheels=" + numberWheels +
                ", engine=" + engine +
                ", price=" + price +
                '}';
    }
}
