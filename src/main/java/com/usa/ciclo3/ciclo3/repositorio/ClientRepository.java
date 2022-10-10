package com.usa.ciclo3.ciclo3.repositorio;

import com.usa.ciclo3.ciclo3.interfaces.ClientInterface;
import com.usa.ciclo3.ciclo3.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class ClientRepository {

    @Autowired
    private ClientInterface clientInterface;

    public List<Client> getAll(){
        return (List<Client>) clientInterface.findAll();
    }

    public Optional<Client> getClient(int id){
        return clientInterface.findById(id);
    }

    public Client save(Client client){
        return clientInterface.save(client);
    }

}
