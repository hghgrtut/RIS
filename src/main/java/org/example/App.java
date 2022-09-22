package org.example;


import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class App {
    private static final String HOST = "localhost";
    private static final int PORT = 1099;
    private static Registry registry;

    public static void main( String[] args ) throws RemoteException, NotBoundException {
        Region regionFirst = new Region("Soviet", 412, 86124, 1241);
        Region regionSecond = new Region("Railway", 231.41,124124, 967);
        City city = new City("Gomel");
        city.addRegion(regionFirst);
        city.addRegion(regionSecond);
//        ObjectSerializable objectSerializable = new ObjectSerializable();
//        objectSerializable.serializableToFile("test", city);
//        City newCity = (City) objectSerializable.deserializeFromFile("test");
//        System.out.println(newCity.toString());

        //Task 3.

//        registry = LocateRegistry.getRegistry(HOST, PORT);
//        City cityRemote = (City) registry.lookup(City.class.getName());
//        System.out.println(cityRemote.getName());



    }
}
