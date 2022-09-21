package org.example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Ship implements Serializable {
    // перечисление полей класса
    private String name; //имя (порядковый номер)
    private List<Cabin> cabins; //список кают

    // конструктор класса
    public Ship(String name) {
        this.name = name;
        this.cabins = new ArrayList<>();
    }
    //добавляет новые каюты в список кают
    public boolean addCabin(Cabin cabin) {
        if(!cabins.contains(cabin)) {
            return cabins.add(cabin);
        } else {
            return false;
        }
    }
// методы класса
    public String getName() {
        return name; //возвращает имя
    }

    public void setName(String name) {
        this.name = name; //устанавливает  значение имени
    }

    public List<Cabin> getCabins() {
        return cabins; //возвращает список кают
    }

    public void setCabins(List<Cabin> cabins) {
        this.cabins = cabins; //утсанавливает
    }

    //переопределение метода
    @Override
    public String toString() {
        return "Ship: '"  + name + '\'' + ", cabins=" + cabins;
    }
}
