package org.example;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class App {

    private static final String HOST = "localhost";
    private static final int PORT = 1099;
    private static Registry registry;

    public static void main( String[] args ) throws IOException, ClassNotFoundException, NotBoundException {

        ITaxiDepot taxiDepot = new TaxiDeport("Fedyuninsky street 25", 2);

        Engine v8 = new Engine("v8", 120, 80);
        Engine v12 = new Engine("v12", 150, 100);

        Car audi = new Car(CarBrand.AUDI, "R8", BodyType.COUPE, 4, v8, 177692.75);
        Car bwm = new Car(CarBrand.BMW, "X5", BodyType.COUPE, 4, v12, 100692.54);

        taxiDepot.registerCar(audi);
        taxiDepot.registerCar(bwm);

        // System.out.println(taxiDepot.calculateCost());

        // ObjectSerialize objectSerialize = new ObjectSerialize();
        // objectSerialize.serializeToFile(audi, "temp");
        // Car car = (Car)objectSerialize.deserializeFromFile("temp");
        // System.out.println(car.toString());

        registry = LocateRegistry.getRegistry(HOST, PORT);
        Car carRemote = (Car) registry.lookup(Car.class.getName());
        System.out.println(carRemote.getBrand().toString());





    }
}
