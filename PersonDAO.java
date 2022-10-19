package com.gmail.annastel.dao;

import org.springframework.stereotype.Component;
import com.gmail.annastel.models.Person;

import java.util.ArrayList;
import java.util.List;


@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private List<Person> people;

    {
        people = new ArrayList<>();

        people.add(new Person(++PEOPLE_COUNT, "Tom"));
        people.add(new Person(++PEOPLE_COUNT, "Bob"));
        people.add(new Person(++PEOPLE_COUNT, "Mike"));
        people.add(new Person(++PEOPLE_COUNT, "Kate"));
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


    public void delete(int id) {
        people.removeIf(p -> p.getId() == id);
    }

    public Integer saveName(String name) {
        Person person = new Person();
        person.setId(++PEOPLE_COUNT);
        person.setName(name);
        people.add(person);
        return PEOPLE_COUNT;
    }
}