package org.example;


public class App {
    public static void main( String[] args ) {
        //создаем объекты-каюты
        Cabin cabinFirst = new Cabin(1, 4);
        Cabin cabinSecond = new Cabin(2, 2);
        //создаем объект-корабль
        Ship ship = new Ship("April");
        // добавляем каюты в корабль
        ship.addCabin(cabinFirst);
        ship.addCabin(cabinSecond);
        //сериализация
        ObjectSerializable objectSerializable = new ObjectSerializable();
        objectSerializable.serializableToFile("test", ship);
        //десериализация
        Ship newShip = (Ship) objectSerializable.deserializeFromFile("test");
        //вывод метода
        System.out.println(newShip.toString());

    }
}
