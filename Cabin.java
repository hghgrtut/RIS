package org.example;

import java.io.Serializable;

public class Cabin implements Serializable {
    // перечисление полей класса
    private int number; //номер каюты
    private int numberOccupant; //количество человек в каюте

    // конструктор класса, задача которого - присвоение значений полям класса
    public Cabin(int number,  int numberOccupant) {
        this.number = number;
        this.numberOccupant = numberOccupant;
    }
  // методы класса
    public int getName() {
        return number; //возвращает номер каюты
    }

    public void setName(String name) {
        this.number = number; //устанавливает номер каюты
    }

    public int getNumberOccupant() {
        return numberOccupant;//возвращает количество человек в каюте
    }

    public void setNumberOccupant(int numberInhabitant) {
        this.numberOccupant = numberOccupant; //устанавливает количество человек в каюте
    }

  //переопределение метода
    @Override
    public String toString() {
        return  "number='" + number + '\'' + ", numberOccupant=" + numberOccupant;
    }
}
