package rmi;

import insurances.PropertyInsurance;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    private static final String HOST = "localhost";
    private static final int PORT = 1099;
    private static Registry registry;

    public static void main(String[] args) throws Exception {
    // ��������� ������� ��������� ��������
        registry = LocateRegistry.getRegistry(HOST, PORT);
    // ��������� ������� �� �������
        PropertyInsurance service = (PropertyInsurance) registry
                .lookup(PropertyInsurance.class.getSimpleName());
        System.out.println("The object from registry:\n" +
                service.toString());
    }
}
