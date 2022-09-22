package org.example;

import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
    private static final int PORT = 1099;
    private static Registry registry;
    public static void startRegistry() throws RemoteException {
        // Create server registry
        registry = LocateRegistry.createRegistry(PORT);
    }
    public static void registerObject(String name, Remote remoteObj)
            throws RemoteException, AlreadyBoundException {
        registry.bind(name, remoteObj);
        System.out.println("Registered: " + name + " -> "
                + remoteObj.getClass().getName() + "[" + remoteObj + "]");
    }
    public static void main(String[] args) throws Exception {
        System.out.println("Server starting...");
        startRegistry();
        //создаем объекты-каюты
        Cabin cabinFirst = new Cabin(1, 4);
        Cabin cabinSecond = new Cabin(2, 2);
        //создаем объект-корабль
        Ship ship = new Ship("April");
        // добавляем каюты в корабль
        ship.addCabin(cabinFirst);
        ship.addCabin(cabinSecond);

        registerObject(Ship.class.getSimpleName(), ship);
        // Server was the start, and was listening to the request from the client.
        System.out.println("Server started!");
        Thread.sleep(10000);//приостановка программы на 10 сек
    }
}
