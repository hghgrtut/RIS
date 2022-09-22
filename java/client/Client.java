package client;

import devices.ElectroDevice;
import devices.Iron;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    // Host or IP of server.Server
    private static final String HOST = "localhost";
    private static final int PORT = 1099;
    private static Registry registry;
    public static void main(String[] args) throws Exception {

        registry = LocateRegistry.getRegistry(HOST, PORT);

        Iron service = (Iron) registry.lookup(Iron.class.getSimpleName());
        service.turnOn();
        System.out.println(service.getPower());
    }
}