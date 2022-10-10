package com.usa.ciclo3.ciclo3.interfaces;

import com.usa.ciclo3.ciclo3.model.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientInterface extends CrudRepository<Client, Integer> {
}
