// Общее  для  всех  вариантов:  реализовать  механизм  сериализации
// (десериализации) объекта согласно индивидуальному заданию
// Вариант 8. Страхование. Определить иерархию страховых обязательств.
// Собрать из обязательств дериватив. Подсчитать стоимость.

import insurances.*;
import participants.*;

import java.io.*;
import java.util.Date;

public class MainProgram {

    public static void main(String args[]) {
        //Создание дериватива
        Derivative derivative = derivativeInit();
        //Отображение содержимого дериватива
        derivative.showInsurances();

        //Адрес сериализации
        String serializeAddress = "D:\\temporary\\save.ser";

        //Сериализация
        derivativeSerial(derivative, serializeAddress);

        //Десериализация
        Derivative derivativeCheck = derivativeDeserial(serializeAddress);
        if(derivativeCheck != null) {
            System.out.println("Десериализации произведена.\nСчитанный диреватив:");
            derivative.showInsurances();
        }
        else
            System.out.println("Десериализация не произведена");
    }

    public static Derivative derivativeInit() {
        Company insuranceComp = new Company("ОАО \"АСБ Беларусбанк\"");
        Person payer =new Person("Невезунов Георг Илларионович");

        PropertyInsurance propInsurance = new PropertyInsurance(insuranceComp, payer,
                300, 28000, new Date(122,8,1),
                new Date(123,8,1), new PropertyItem("Квартира"));
        PersonalInsurance  persInsurance = new PersonalInsurance(insuranceComp, payer,
                50, 1500, new Date(122,8,1),
                new Date(123,8,1), payer);
        LiabilityInsurance liabInsurance = new LiabilityInsurance(insuranceComp, payer,
                50, 1500, new Date(122, 8,1),
                new Date(123, 8,1), payer);

        Derivative derivative = new Derivative();
        derivative.addInsurance(propInsurance);
        derivative.addInsurance(persInsurance);
        derivative.addInsurance(liabInsurance);
        return derivative;
    }

    public static void derivativeSerial(Derivative derivative,
                                        String serializeAddress) {
        try {
            System.out.println("\nПопытка сериализации...");
            FileOutputStream outputStream = new FileOutputStream(serializeAddress);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(derivative);
            objectOutputStream.close();
            System.out.println("Сериализации произведена.\nАдрес: " + serializeAddress);
        }
        catch(Exception e) {
            System.out.println("Выброшено исключение:\n" + e.getLocalizedMessage());
        }
    }

    public static Derivative derivativeDeserial(String serializeAddress) {
        try {
            System.out.println("\nПопытка десериализации...");
            FileInputStream inputStream = new FileInputStream(serializeAddress);
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            return (Derivative)objectInputStream.readObject();
        }
        catch(Exception e) {
            System.out.println("Выброшено исключение:\n" + e.getLocalizedMessage());
        }
        return null;
    }
}
