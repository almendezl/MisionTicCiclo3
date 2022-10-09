package com.usa.ciclo3.ciclo3.repository;

import com.usa.ciclo3.ciclo3.entities.Client;
import com.usa.ciclo3.ciclo3.entities.Product;
import com.usa.ciclo3.ciclo3.repository.crudRepository.ClientCrudRepository;
import com.usa.ciclo3.ciclo3.repository.crudRepository.ProductCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClientRepository {
    @Autowired
    private ClientCrudRepository clientCrudRepository;

    public List<Client> getAll(){
        return (List<Client>) clientCrudRepository.findAll();
    }

    public Optional<Client>  getClient(int id){
        return clientCrudRepository.findById(id);
    }

    public Client save(Client c){
        //si existe lo actualiza, si no exisate lo guarda
        return clientCrudRepository.save(c);
    }

    public void delete(Client c){
        clientCrudRepository.delete(c);
    }
}
