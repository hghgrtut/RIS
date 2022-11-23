package ru.mail.yuriyhrom.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.mail.yuriyhrom.DAO.PersonDAO;
import ru.mail.yuriyhrom.models.Person;

//Класс является контроллером и обрабатывает запросы с /people...
@Controller
@RequestMapping("/people")
public class PeopleController {
    //Класс хранит в себе объект PersonDAO, бин которого внедряется автоматически
    //благодаря использованию аннотации @Autowired над конструктором
    private final PersonDAO personDAO;

    @Autowired
    public PeopleController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    // Обрабатывает get-запрос /people
    //Передает список всех людей в представление
    @GetMapping()
    public String showAll(Model model) {
        model.addAttribute("people", personDAO.showAll());
        return "people/showAll";
    }

    // Обрабатывает get-запрос /people/{id}
    //Передает в представление одного человека с id={id}
    @GetMapping("/{id}")
    public String showById(@PathVariable("id") int id, Model model) {
        model.addAttribute("person", personDAO.showById(id));
        return "people/showById";
    }

    // Обрабатывает get-запрос /people/new
    //Предоставляет доступ к форме для заполнения информации о создаваемом человеке
    @GetMapping("/new")
    public String newPerson(@ModelAttribute("person") Person person) {
        return "people/new";
    }

    // Обрабатывает post-запрос создания человека с валидацией
    //Создает нового человека по данным, полученным из формы, и добавляет его в "БД"
    @PostMapping()
    public String create(@ModelAttribute("person") @Valid Person person,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "people/new";
        personDAO.save(person);
        return "redirect:/people";
    }

    // Обрабатывает get-запрос /people/edit
    //Предоставляет доступ к форме для редактирования информации о человеке с указанным id
    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("person", personDAO.showById(id));
        return "people/edit";
    }

    // Обрабатывает patch-запрос редактирования человека с валидацией
    // (с использованием фильтра, установленного в классе MySpringMvcDispatcherServletInitializer,
    // анализирующего наличие скрытого поля _method и его содержание)
    //Редактирует человека согласно данным, полученным из формы
    @PatchMapping("/{id}")
    public String update(@ModelAttribute("person") @Valid Person person,
                         BindingResult bindingResult, @PathVariable("id") int id) {
        if (bindingResult.hasErrors())
            return "people/edit";
        personDAO.update(id, person);
        return "redirect:/people";
    }

    // Обрабатывает delete-запрос на удаление человека
    // (с использованием фильтра, установленного в классе MySpringMvcDispatcherServletInitializer,
    // анализирующего наличие скрытого поля _method и его содержание)
    //Удаляет человека по id
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        personDAO.delete(id);
        return "redirect:/people";
    }
}