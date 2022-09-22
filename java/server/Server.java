package server;

import devices.Iron;

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
        System.out.println("server.Server starting...");
        startRegistry();
        registerObject(Iron.class.getSimpleName(), new Iron("Виктор", 100.0));
// server.Server was the start, and was listening to the request from thе client.
                System.out.println("server.Server started!");
        while(true){}
    }
}