package org.example;

import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIServer {
    private static final String HOST = "localhost";
    private static final int PORT = 1099;
    private static Registry registry;

    public static Registry getRegistry() throws RemoteException {
        return registry = LocateRegistry.createRegistry(PORT);
    }

    public static void registerObject(String name, Remote object) throws RemoteException, AlreadyBoundException {
        registry.bind(name, object);
    }


    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        getRegistry();
        registerObject(Car.class.getSimpleName(), new Car(CarBrand.AUDI));
    }
}
