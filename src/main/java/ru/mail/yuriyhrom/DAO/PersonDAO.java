package ru.mail.yuriyhrom.DAO;

import org.springframework.stereotype.Component;
import ru.mail.yuriyhrom.models.Person;

import java.util.ArrayList;
import java.util.List;

// Класс DAO, т.е. класс для взаимодействия с "БД" людей, имитируемой списком
//Бин класса создастся Spring-ом автоматически
@Component
public class PersonDAO {
    //Статическое поле для отсчета id
    private static int idCount = 0;

    //Имитация БД
    private List<Person> people;

    {
        people = new ArrayList<>();
        people.add(new Person(++idCount, "Misha", 35, "misha_mish@mail.ru"));
        people.add(new Person(++idCount, "Masha", 24, "mashinka@gmail.com"));
        people.add(new Person(++idCount, "Pasha", 29, "pavidlo@gmail.com"));
        people.add(new Person(++idCount, "Natasha", 37, "vasha_natasha@gmail.com"));
        people.add(new Person(++idCount, "Gosha", 19, "go_go_gosha@gmail.com"));
        people.add(new Person(++idCount, "Alyosha", 41, "allo_allyosha@gmail.com"));
    }

    //Получение списка всех людей
    public List<Person> showAll() {
        return people;
    }

    //Получение одного человека по id
    public Person showById(int id) {
        return people.stream().filter(person -> person.getId()==id).findAny().orElse(null);
    }

    //Добавление нового человека в "БД"
    public void save(Person person) {
        person.setId(++idCount);
        people.add(person);
    }

    //Сохранение изменений в человеке
    public void update(int id, Person updatedPerson) {
        Person personToBeUpdated = showById(id);
        personToBeUpdated.setName(updatedPerson.getName());
        personToBeUpdated.setAge(updatedPerson.getAge());
        personToBeUpdated.setEmail(updatedPerson.getEmail());
    }

    //Удаляет человека из "БД" по id
    public void delete(int id) {
        people.removeIf(p -> p.getId() == id);
    }
}
