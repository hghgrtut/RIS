package org.example;


public class App {
    public static void main( String[] args ) {
        Region regionFirst = new Region("Soviet", 412, 86124, 1241);
        Region regionSecond = new Region("Railway", 231.41,124124, 967);
        City city = new City("Gomel");
        city.addRegion(regionFirst);
        city.addRegion(regionSecond);
        ObjectSerializable objectSerializable = new ObjectSerializable();
        objectSerializable.serializableToFile("test", city);
        City newCity = (City) objectSerializable.deserializeFromFile("test");
        System.out.println(newCity.toString());

    }
}
