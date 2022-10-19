package com.kharitonov.myTestApi.controller;

import com.kharitonov.myTestApi.entity.Message;
import com.kharitonov.myTestApi.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/messages")
@CrossOrigin(origins = "*", originPatterns = "*")
public class MessageController {

    private MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping
    public List<Message> getAllMessage() {
        return messageService.findAll();
    }

    @GetMapping("/{id}")
    public Message getByIdMessage(@PathVariable("id") Message message) {
        return message;
    }

    @PostMapping
    public Message saveMessage(@RequestBody Message message) {
        return messageService.save(message);
    }

    @DeleteMapping("/{id}")
    public void deleteMessage(@PathVariable("id") Message message) {
        messageService.delete(message);
    }
}
