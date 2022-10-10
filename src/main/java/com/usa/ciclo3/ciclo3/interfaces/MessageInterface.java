package com.usa.ciclo3.ciclo3.interfaces;

import com.usa.ciclo3.ciclo3.model.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageInterface extends CrudRepository<Message, Integer> {
}
