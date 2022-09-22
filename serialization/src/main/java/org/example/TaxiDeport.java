package org.example;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TaxiDeport implements ITaxiDepot, Serializable {

    private String address;
    private int parkingPlace;
    private List<Car> cars;
    private double sum;

    public TaxiDeport(String address, int parkingPlace) {
        this.address = address;
        this.parkingPlace = parkingPlace;
        cars = new ArrayList<>();
    }

    @Override
    public boolean registerCar(Car car) {
        if(cars.size() < parkingPlace) {
            cars.add(car);
            return true;
        } else {
            throw  new RuntimeException("Limit is exceeded");
        }
    }

    @Override
    public boolean deleteCar(Car car) {
        if(cars.contains(car)) {
            cars.remove(car);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public double calculateCost() {
        for(Car car: cars) {
            sum += car.getPrice();
        }
        return sum;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getParkingPlace() {
        return parkingPlace;
    }

    public void setParkingPlace(int parkingPlace) {
        this.parkingPlace = parkingPlace;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public double getSum() {
        return sum;
    }

    @Override
    public String toString() {
        return "TaxiDeport{" +
                "address='" + address + '\'' +
                ", parkingPlace=" + parkingPlace +
                ", cars=" + cars +
                ", sum=" + sum +
                '}';
    }
}
