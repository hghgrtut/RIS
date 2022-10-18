package com.gmail.chitakov2606nikita.dao;

import com.gmail.chitakov2606nikita.models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private List<Person> people;

    {
        people = new ArrayList<>();

        people.add(new Person(++PEOPLE_COUNT, "Abraham", "abraham@mail.ru", 43));
        people.add(new Person(++PEOPLE_COUNT, "Nikita", "nick@mail.ru", 22));
        people.add(new Person(++PEOPLE_COUNT, "Vladislav", "vladyahoo.com", 20));
        people.add(new Person(++PEOPLE_COUNT, "Vasya", "vs@gmail.com", 18));
    }

    public List<Person> index() {

        return people;
    }

    public Person show(int id) {

        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public void update(int id, Person updatedPerson) {
        Person personToBeUpdated = show(id);

        personToBeUpdated.setName(updatedPerson.getName());
        personToBeUpdated.setEmail(updatedPerson.getEmail());
        personToBeUpdated.setAge(updatedPerson.getAge());
    }

    public void delete(int id) {

        people.removeIf(p -> p.getId() == id);
    }

    public Integer savePerson(String name, String email, Integer age) {
        Person person = new Person();
        person.setId(++PEOPLE_COUNT);
        person.setName(name);
        person.setEmail(email);
        person.setAge(age);
        people.add(person);
        return PEOPLE_COUNT;
    }
}