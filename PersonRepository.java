package com.gmail.chitakov2606nikita.springbootdemo.repository;

import com.gmail.chitakov2606nikita.springbootdemo.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}