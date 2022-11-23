package ru.mail.yuriyhrom.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

//Собственно класс-модель для человека
public class Person {
    //Поля класса предусматривают валидацию через аннотации
    private int id;

    @NotEmpty(message = "Name shouldn't be empty")
    @Size(min = 1, max = 35, message = "Name should be between 1 and 35 characters")
    private String name;

    @Min(value = 0, message = "Age shouldn't be negative")
    private int age;

    @NotEmpty(message = "Email shouldn't be empty")
    @Email(message = "Email should be valid")
    private String email;

    public Person() {}

    public Person(int id, String name, int age, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
