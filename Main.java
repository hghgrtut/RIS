package org.example;


public class Main {
    public static void main(String[] args) {

        CargoShip cs1 = new CargoShip("April", 1999, 100);
        CargoShip cs2 = new CargoShip("June", 2001, 80);
        cs1.showInfoCargo();
        cs2.showInfoCargo();

    }
}