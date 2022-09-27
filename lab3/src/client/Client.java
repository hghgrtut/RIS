package client;

import classes.KitchenRoom;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {

    private static final String HOST = "localhost";
    private static final int PORT = 1099;
    private static Registry registry;
    public static void main(String[] args) throws Exception {

        registry = LocateRegistry.getRegistry(HOST, PORT);

        KitchenRoom service = (KitchenRoom) registry.lookup(KitchenRoom.class.getSimpleName());
        System.out.println(service);
        service.getIn(12);
        service.setIsWorking(true);
        System.out.println(service);
    }
}