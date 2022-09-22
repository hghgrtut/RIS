import devices.ElectroDevice;
import devices.Fridge;
import devices.Iron;
import devices.Teapot;

import java.util.ArrayList;
import java.util.List;
import java.io.*;


public class main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        double allPower = 0.0;
        List ls = new ArrayList<ElectroDevice>();

        Fridge f = new Fridge("Horizont", 1312.15);
        ls.add(f);
        f.turnOn();

        Iron i1 = new Iron("Zenda", 407.84);
        ls.add(i1);

        Iron i2 = new Iron("Vitek", 123.64);
        ls.add(i2);
        i2.turnOn();

        Teapot t = new Teapot("Bosh", 512.297);
        ls.add(t);
        t.turnOn();

        for(int i = 0; i < ls.size(); i++)
        {
            allPower += ((ElectroDevice)ls.get(i)).getPower();
        }

        System.out.println(f);
        System.out.println(i1);
        System.out.println(i2);
        System.out.println(t);
        System.out.println("\nSum Of Power Of Devices.ElectroDevice = " + allPower);

        //создаем 2 потока для сериализации объектов и сохранения их в файл
        FileOutputStream outputStream = new FileOutputStream("E:\\ГИ-31\\Chitakov\\labs\\lab3\\save.ser");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

        // сохраняем объекты в файл
        objectOutputStream.writeObject(f);
        objectOutputStream.writeObject(i1);
        objectOutputStream.writeObject(i2);
        objectOutputStream.writeObject(t);

        //закрываем поток и освобождаем ресурсы
        objectOutputStream.close();

        //создаем 2 потока для десериализации объектов и изъятия их из файла
        FileInputStream fileInputStream = new FileInputStream("E:\\ГИ-31\\Chitakov\\labs\\lab3\\save.ser");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        Fridge f_s = (Fridge) objectInputStream.readObject();
        Iron i1_s = (Iron) objectInputStream.readObject();
        Iron i2_s = (Iron) objectInputStream.readObject();
        Teapot t_s = (Teapot) objectInputStream.readObject();

        //вывод объектов после сериализации
        System.out.println("\n" + f_s);
        System.out.println(i1_s);
        System.out.println(i2_s);
        System.out.println(t_s);
    }
}
