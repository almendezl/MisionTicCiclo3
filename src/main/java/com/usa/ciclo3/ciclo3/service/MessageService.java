package com.usa.ciclo3.ciclo3.service;

import com.usa.ciclo3.ciclo3.model.Message;
import com.usa.ciclo3.ciclo3.repositorio.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getAll(){
        return messageRepository.getAll();
    }

    public Optional<Message> getMessage(int id){
        return messageRepository.getMessage(id);
    }

    public Message save (Message message){
        if (message.getIdMessage() == null){
            return messageRepository.save(message);
        } else {
            Optional<Message> message1 = messageRepository.getMessage(message.getIdMessage());
            if(!message1.isPresent()){
                return messageRepository.save(message);
            } else {
                return message;
            }
        }
    }
}
