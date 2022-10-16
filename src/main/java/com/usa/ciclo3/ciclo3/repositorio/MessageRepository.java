package com.usa.ciclo3.ciclo3.repositorio;

import com.usa.ciclo3.ciclo3.interfaces.MessageInterface;
import com.usa.ciclo3.ciclo3.model.Client;
import com.usa.ciclo3.ciclo3.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class MessageRepository {

    @Autowired
    private MessageInterface messageInterface;

    public List<Message> getAll(){
        return (List<Message>) messageInterface.findAll();
    }

    public Optional<Message> getMessage(int id){
        return messageInterface.findById(id);
    }

    public Message save(Message message){
        return messageInterface.save(message);
    }

    public void delete(Message message){
        messageInterface.delete(message);
    }
}
