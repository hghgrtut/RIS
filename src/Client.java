import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;

public class Client {
    private static final String HOST = "Localhost";
    private static final int PORT = 1099;
    private static Registry registry;
    public static void main(String[] args) throws Exception {
        registry = LocateRegistry.getRegistry(HOST, PORT);

        Operator service = (Operator) registry.lookup(Operator.class.getSimpleName());
        Tarif tarif1 = new Tarif("A1",23);
        Tarif tarif2 = new Tarif("A2", 18);

        List<Tarif> tarifList = service.getTarifList();
        tarifList.add(tarif1);
        tarifList.add(tarif2);

        System.out.println(tarifList.toString());
    }

}
