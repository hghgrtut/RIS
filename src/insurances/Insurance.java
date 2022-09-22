package insurances;

import participants.*;

import java.io.Serializable;
import java.util.Date;
import java.text.SimpleDateFormat;

//Абстрактный класс страховых обязательств
public abstract class Insurance implements Serializable {
    //идентивикатор сериализации
    protected static final long serialVersionUID = 1L;

    //Страховая компания
    protected Company m_company;
    //Страхователь
    protected Person m_payer;
    //Цена страховки
    protected double m_price;
    //Страховая сумма
    protected double m_insuranceSum;
    //Дата заключения договора
    protected Date m_startDate;
    //Дата истечения срока действия договора
    protected Date m_endDate;

    //геттеры
    public Company getCompany() {
        return m_company;
    }
    public Person getPayer() {
        return m_payer;
    }
    public double getPrice() {
        return m_price;
    }
    public double getInsuranceSum() {
        return m_insuranceSum;
    }
    public Date getStartDate() {
        return m_startDate;
    }
    public Date getEndDate() {
        return m_endDate;
    }

    //конструктор
    public Insurance(Company company, Person payer, double price,
                     double insuranceSum, Date start, Date end)
    {
        this.m_company = company;
        this.m_payer = payer;
        this.m_price = price;
        this.m_insuranceSum = insuranceSum;
        this.m_startDate = start;
        this.m_endDate = end;
    }

    //конвертация
    @Override
    public String toString() {
        return  "\n Страховщик: " + m_company.getInfo() +
                "\n Страхователь: " + m_payer.getInfo() +
                "\n Стоимость: $" + m_price +
                "\n Страховая сумма: $" + m_insuranceSum +
                "\n Дата заключения: " +
                m_startDate.toLocaleString().replace(", 00:00:00", "") +
                "\n Дата истечения: " +
                m_endDate.toLocaleString().replace(", 00:00:00", "");
    }
}
