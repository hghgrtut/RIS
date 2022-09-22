import org.example.ObjectSerializable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        //создаем объекты-дома
        House house1 = new House("10a", 5);
        House house2 = new House("11", 6);

        // добавляем в улицу дома, созданные ранее
        List<House> streets = new ArrayList<>();
        streets.add(house1);
        streets.add(house2);
        //создаем объект-улица
        Street sovet = new Street("Советская", streets);

        //сериализация
        ObjectSerializable objectSerializable = new ObjectSerializable();
        objectSerializable.serializableToFile("test", streets);

        //десериализация
        Street newShip = (Street) objectSerializable.deserializeFromFile("test");

        sovet.Information();

    }
}


