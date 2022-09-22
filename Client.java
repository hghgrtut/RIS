package org.example;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Date;

public class Client {
 // Host or IP of Server
     private static final String HOST = "localhost";
     private static final int PORT = 1099;
     private static Registry registry;

 public static void main(String[] args) throws Exception {

  // Search the registry in the specific Host, Port.
  registry = LocateRegistry.getRegistry(HOST, PORT);
  // Lookup ship in the Registry.
  ShipIn ship = (ShipIn) registry
          .lookup(Ship.class.getSimpleName());

  ship.toString();
 }
}
