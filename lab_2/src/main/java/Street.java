import java.io.Serializable;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

//создаем класс улицы, в котором прописаны дома и квартиры этой улицы
public class Street implements Serializable, StreetIn {
    // перечисление полей класса
    private String name; // имя улицы
    private List<House> houses; // список домов на улице

    // конструктор класса, задача которого - присвоение значений полям класса
    public Street(String n, List<House> h) {
        name = n;
        houses = h;
    }

    //вывод названия улицы и домов, расположенных на этой улице, с количеством квартир
    public void Information() {
        System.out.println("Улица: " + name);
        for (int i = 0; i < houses.size(); i++) {
            House house = houses.get(i);
            System.out.println("дом: " + house.getName() + ", количество подъездов: " + house.getCount());
        }
    }
}