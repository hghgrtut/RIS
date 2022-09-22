import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;

public class Client {

    private static final String HOST = "localhost";
    private static final int PORT = 1099;
    private static Registry registry;

    public static void main(String[] args) throws Exception {

        registry = LocateRegistry.getRegistry(HOST, PORT);

        Flowers service = (Flowers) registry.lookup(Flowers.class.getSimpleName());
        Roza flower = new Roza("Roza", 15, 1);
        Vasilek flowersecond = new Vasilek("Vasilek", 10, 10);
        Acsesuars acsesuars = new Acsesuars("lenta", 20, 1);

        List<Flower> flowerList = service.getFlowerList();
        flowerList.add(flower);
        flowerList.add(flowersecond);
        flowerList.add(acsesuars);

        System.out.println(service.getCost());
    }
}