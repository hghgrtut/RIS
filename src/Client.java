import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;

public class Client {
    // Host or IP of Server
    private static final String HOST = "localhost";
    private static final int PORT = 1099;
    private static Registry registry;
    public static void main(String[] args) throws Exception {

        registry = LocateRegistry.getRegistry(HOST, PORT);

        Company service = (Company) registry.lookup(Company.class.getSimpleName());
        Airplane airplane1 = new Airplane("A1",1.0, 2.0);
        Airplane airplane2 = new Airplane("A2",3.0, 4.0);

        List<Airplane> airList = service.getAirplaneList();
        airList.add(airplane1);
        airList.add(airplane2);


        System.out.println();
    }
}
