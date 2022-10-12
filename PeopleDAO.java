package com.example.lab5.dao;

import com.example.lab5.models.Person;

import java.util.List;

/**
 * The interface People dao.
 */
public interface PeopleDAO {
    /**
     * Select person by id peron.
     *
     * @param idPerson the id person
     * @return the person
     */
    Person selectPersonById(Long idPerson);

    /**
     * Select all people list.
     *
     * @return the list
     */
    List<Person> selectAllPeople();

    /**
     * Update person.
     *
     * @param person the person
     */
    void updatePerson(Person person);

    /**
     * Add person.
     *
     * @param person the person
     */
    void addPerson(Person person);

    /**
     * Delete person.
     *
     * @param person the person
     */
    void deletePerson(Person person);
}