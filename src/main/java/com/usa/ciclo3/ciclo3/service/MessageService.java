package com.usa.ciclo3.ciclo3.service;

import com.usa.ciclo3.ciclo3.model.Client;
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

    public Message updateMessage(Message message){
        if(message.getIdMessage() != null ){
            Optional<Message> g = messageRepository.getMessage(message.getIdMessage());
            if(g.isPresent()){
                if(message.getMessageText() != null ){
                    g.get().setMessageText(message.getMessageText());
                }


                return messageRepository.save(g.get());

            }

        }
        return message;
    }

    public boolean deleteMessage(int id){
        Boolean d = getMessage(id).map(message ->{
            messageRepository.delete(message);
            return true;
        }).orElse(false);
        return d;
    }
}
