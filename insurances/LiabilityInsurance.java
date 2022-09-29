package insurances;

import participants.*;
import java.util.Date;

//Вид страховки - страхование ответственности
public class LiabilityInsurance extends Insurance {
    //Предмет страхования - ответственность перед третьими
    //лицами со стороны указанного человека
    protected Person m_subject;

    //геттеры
    public Person getSubject() {
        return m_subject;
    }

    //конструктор
    public LiabilityInsurance(Company company, Person payer, double price,
                             double insuranceSum, Date start, Date end, Person subject)
    {
        super(company, payer, price, insuranceSum, start, end);
        this.m_subject = subject;
    }

    //конвертация
    @Override
    public String toString() {
        return "--- Страхование ответственности ---\n" +
                " Застрахованное лицо: " + m_subject.getInfo() +
                super.toString();
    }
}
