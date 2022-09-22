import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.rmi.Remote;

public class MainApp {
    public static void main(String[] args) throws IOException {
        Airplane airplane1 = new Airplane("A1",1.0, 2.0);
        Airplane airplane2 = new Airplane("A2",3.0, 4.0);

        List<Airplane> airList = new ArrayList<>();
        airList.add(airplane1);
        airList.add(airplane2);

        Company company = new Company("name",airList);
        String param = company.getParam();
        System.out.println(param);

        //создаем 2 потока для сериализации объекта и сохранения его в файл
        FileOutputStream outputStream = new FileOutputStream("save.bin");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

        // сохраняем игру в файл
        objectOutputStream.writeObject(company);

        //закрываем поток и освобождаем ресурсы
        objectOutputStream.close();
    }

}
