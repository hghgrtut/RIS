package com.gmail.annastel.controllers;

import com.gmail.annastel.dao.PersonDAO;
import com.gmail.annastel.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    private final PersonDAO personDAO;

    @Autowired
    public RestController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @GetMapping("/ajax/{id}")
    public String ajax(@PathVariable("id") int id) {     /* Удаление людей из списка*/
        personDAO.delete(id);
        return "Ok";
    }

    @GetMapping("/create/{name}")
    public String create(@PathVariable("name") String name) { return personDAO.saveName(name).toString();  /*Созданеи  людей в списке*/
    }
}