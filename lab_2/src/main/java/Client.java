import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    // Хост или IP сервера
    private static final String HOST = "localhost";
    private static final int PORT = 1099;
    private static Registry registry;

    public static void main(String[] args) throws Exception {
// Поиск риестра в специальном  хосте, порту
        registry = LocateRegistry.getRegistry(HOST, PORT);
// Подстановка в риестр
        StreetIn street = (StreetIn) registry
                .lookup(StreetIn.class.getSimpleName());

// вызов метода
        street.Information();
    }
}