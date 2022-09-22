import insurances.*;

import java.io.Serializable;
import java.util.ArrayList;


class Derivative implements Serializable {
    //идентивикатор сериализации
    protected static final long serialVersionUID = 1L;

    //массив страховых обязательств
    protected ArrayList<Insurance> m_insurances;

    //конструктор
    public Derivative() {
        m_insurances = new ArrayList<Insurance>();
    }

    //Добавление обязательства
    public void addInsurance(Insurance insurance) {
        m_insurances.add(insurance);
    }

    //Расчет общей стоимости
    public double totalPrice() {
        double totalPrice = 0;
        for(Insurance item : m_insurances) {
            totalPrice += item.getPrice();
        }
        return totalPrice;
    }

    //Просмотр обязательств по деривативу
    public void showInsurances() {
        System.out.println("\nСОСТАВ ДЕРИВАТИВА:");
        for(Insurance item : m_insurances) {
            System.out.println("\n" + item.toString());
        }
        System.out.println("\nОБЩАЯ СТОИМОСТЬ: " + this.totalPrice());
    }
}
