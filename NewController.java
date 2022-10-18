package com.gmail.chitakov2606nikita.controllers;

import com.gmail.chitakov2606nikita.dao.PersonDAO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@org.springframework.web.bind.annotation.RestController
public class NewController {
    private final PersonDAO personDAO;

    @Autowired
    public NewController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @GetMapping("/ajax/{id}")
    public String ajax(@Valid @PathVariable("id") int id) {
        personDAO.delete(id);
        return "Ok";
    }

    @GetMapping("/create/{name}")
    public String create(@Valid @PathVariable("name") String name, @Valid @PathVariable("email") String email, @Valid @PathVariable("age") Integer age) {

        return personDAO.savePerson(name, email, age).toString();
    }
}