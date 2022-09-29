package rmi;

import insurances.PropertyInsurance;
import participants.*;

import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.RemoteObject;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;

public class Server {
    private static final int PORT = 1099;
    private static Registry registry;

    //Создаем реестр удаленных объектов
    public static void startRegistry() throws RemoteException {
        registry = LocateRegistry.createRegistry(PORT);
    }
    //Регистрируем заглушку в реестре
    public static void registerObject(String name, Remote remoteObj)
            throws RemoteException, AlreadyBoundException {
        registry.bind(name, remoteObj);
        System.out.println("Registered: " + name + " -> "
                + remoteObj.getClass().getName() + "[\n" + remoteObj + "]");
    }

    public static void main(String[] args) throws Exception {
        System.out.println("\nServer starting...");
        startRegistry();
        //Создаем новую страховку и заносим ее в реестр
        PropertyInsurance propInsurance = new PropertyInsurance(
                new Company("Belarusbank"),
                new Person("Unfortunatov George Illarionavich"),
                300, 28000,
                new Date(122,8,1),
                new Date(123,8,1),
                new PropertyItem("Apartment"));
        registerObject(PropertyInsurance.class.getSimpleName(), propInsurance);
        //Ожидаем запрос от клиента
        System.out.println("Server started!");
        Thread.sleep(Integer.MAX_VALUE);
    }
}
