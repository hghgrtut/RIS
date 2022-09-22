package insurances;

import participants.*;
import java.util.Date;

//Вид страховки - личное страхование
public class PersonalInsurance extends Insurance {
    //Предмет страхования - жизнь и здоровье человека
    protected Person m_subject;

    //геттеры
    public Person getSubject() {
        return m_subject;
    }

    //конструктор
    public PersonalInsurance(Company company, Person payer, double price,
                             double insuranceSum, Date start, Date end, Person subject)
    {
        super(company, payer, price, insuranceSum, start, end);
        this.m_subject = subject;
    }
    //конвертация
    @Override
    public String toString() {
        return "--- Личное страхование ---\n" +
                " Застрахованным является " + m_subject.getInfo() +
                super.toString();
    }
}
