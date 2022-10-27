package com.example.lab6;

import com.example.lab6.domain.Message;
import com.example.lab6.repos.MessageRepo;
import com.example.lab6.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MyController {

    @Autowired
    private MessageService messageService;

    @GetMapping("/message/{id}")
    public String getMessage(Model model, @PathVariable("id") Long id) {
        Message message = messageService.findById(id);
        model.addAttribute("message", message.getText());
        return "message";
    }

    @GetMapping("/messages")
    public String getMessages(Model model) {
        List<Message> all = messageService.findAll();
        model.addAttribute("messages", all);
        return "messages";
    }

    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable("id") Long id) {
        Message message = messageService.findById(id);
        model.addAttribute("message", message.getText());
        messageService.deleteById(id);
        return "delete";
    }

    @GetMapping("/create")
    public String viewCreate() {
        return "create";
    }

    @PostMapping("/create")
    public String create(Model model, @ModelAttribute("message") String text) {
        messageService.createMessage(text);
        List<Message> all = messageService.findAll();
        model.addAttribute("messages", all);
        return "messages";
    }

    @GetMapping("/edit/{id}")
    public String viewEdit(Model model, @PathVariable("id") Long id) {
        Message message = messageService.findById(id);
        model.addAttribute("message", message);
        return "edit";
    }

    @PostMapping("/edit")
    public String edit(Model model, @ModelAttribute("message") Message message) {
        messageService.save(message);
        List<Message> all = messageService.findAll();
        model.addAttribute("messages", all);
        return "messages";
    }

}
