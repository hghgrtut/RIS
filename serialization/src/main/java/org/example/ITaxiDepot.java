package org.example;

public interface ITaxiDepot {
    boolean registerCar(Car car);
    boolean deleteCar(Car car);

    double calculateCost();
}
