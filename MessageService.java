package com.example.lab6.services;

import com.example.lab6.domain.Message;
import com.example.lab6.repos.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    @Autowired
    private MessageRepo messageRepo;


    public void createMessage(String text) {
        Message message = new Message();
        message.setText(text);
        messageRepo.save(message);
    }

    public List<Message> findAll() {
        return messageRepo.findAll();
    }

    public Message findById(Long id) {
        return messageRepo.findById(id).get();
    }

    public void deleteById(Long id) {
        messageRepo.deleteById(id);
    }


    public void save(Message message) {
        messageRepo.save(message);
    }
}
