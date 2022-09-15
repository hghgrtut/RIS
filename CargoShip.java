package org.example;

public class CargoShip extends Ship { // наследование от класса корабль
    private int loadCapacity; // грузоподъемность
    // конструктор класса
    public CargoShip(String name,  int year, int loadCapacity) {
        super(name,  year);
        this.loadCapacity = loadCapacity;

    }
    // методы класса
    public void showInfoCargo() {

        super.showInfo();
        System.out.println("load capacity: " + loadCapacity + " tones");


    }
}
