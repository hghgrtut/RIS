import java.io.Serializable;
import java.util.List;


public class Street implements Serializable {
    // перечисление полей класса
    private String name; // имя улицы
    private List<House> houses; // список домов на улице


    // конструктор класса, задача которого - присвоение значений полям класса
    public Street(String n, List<House> h) {
        name = n;
        houses = h;

    }
    //вывод названия улицы и домов, расположенных на этой улице, с количеством квартир
    public void nnn() {
        System.out.println("Улица: "+ name);
        for (int i = 0; i < houses.size(); i++) {
            House house = houses.get(i);
            System.out.println("дом: "+house.getName()+", количество подъездов: "+house.getCount());

        }
    }
}