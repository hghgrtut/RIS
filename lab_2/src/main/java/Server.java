import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;

public class Server {
    //порт для того, чтобы клиент смог подключиться
    private static final int PORT = 1099;
    private static Registry registry;

    public static void startRegistry() throws RemoteException {
        // создаем серверный регистр
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

        //создаем объекты-дома
        House house1 = new House("10a", 5);
        House house2 = new House("11", 6);

        // добавляем в улицу дома, созданные ранее
        List<House> streets = new ArrayList<>();
        streets.add(house1);
        streets.add(house2);

        //создаем объект-улица
        Street sovet = new Street("Советская", streets);

        registerObject(StreetIn.class.getSimpleName(), sovet);

        // Сервер запустился и слушает запросы от клиента
        System.out.println("Server started!");

        //остановка программы на 10 минут
        Thread.sleep(10000);
    }
}


