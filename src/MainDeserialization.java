import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class MainDeserialization {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        FileInputStream fileInputStream = new FileInputStream("save.bin");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        Company company = (Company) objectInputStream.readObject();

        System.out.println(company.getParam());
    }
}