package com.kharitonov.myTestApi.service;

import com.kharitonov.myTestApi.entity.Message;
import com.kharitonov.myTestApi.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    public final MessageRepository messageRepository;

    @Autowired
    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public List<Message> findAll() {
        return messageRepository.findAll();
    }

    public Message save(Message message) {
        return messageRepository.save(message);
    }

    public Message findById(Long id) {
        return messageRepository.findById(id).get();
    }

    public boolean existsById(Long id) {
        return messageRepository.existsById(id);
    }

    public void delete(Message message) {
        messageRepository.delete(message);
    }
}
