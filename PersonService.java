package com.gmail.chitakov2606nikita.springbootdemo.service;

import com.gmail.chitakov2606nikita.springbootdemo.model.Person;
import com.gmail.chitakov2606nikita.springbootdemo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person findById(Long id){
        return personRepository.getOne(id);
    }

    public List<Person> findAll(){
        return personRepository.findAll();
    }

    public Person savePerson(Person person){
        return personRepository.save(person);
    }

    public void deleteById(Long id){
        personRepository.deleteById(id);
    }
}
