import java.io.Serializable;

public class House implements Serializable {

    // перечисление полей класса
    private String name; // номер дома
    private int count; // количество подъездов


    // конструктор класса, задача которого - присвоение значений полям класса
    public House(String n, int c) {
        name = n;//название дома
        count = c;//количество подъездов
    }

//геттеры и сеттеры для домов
    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}