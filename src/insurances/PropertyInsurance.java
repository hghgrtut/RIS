package insurances;

import participants.*;
import java.util.Date;

//Вид страховки - страхование имущества
public class PropertyInsurance extends Insurance {
    //Предмет страхования - имущество
    protected PropertyItem m_subject;

    //геттеры
    public PropertyItem getSubject() {
        return m_subject;
    }

    //конструктор
    public PropertyInsurance(Company company, Person payer, double price,
                     double insuranceSum, Date start, Date end, PropertyItem subject)
    {
        super(company, payer, price, insuranceSum, start, end);
        this.m_subject = subject;
    }
    //конвертация
    @Override
    public String toString() {
        return "--- Страхование имущества ---\n" +
                " Предмет страхования: " + m_subject.getInfo() +
                super.toString();
    }
}
