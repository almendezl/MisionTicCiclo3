package com.usa.ciclo3.ciclo3.service;

import com.usa.ciclo3.ciclo3.model.Cinema;
import com.usa.ciclo3.ciclo3.model.Client;
import com.usa.ciclo3.ciclo3.repositorio.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAll(){
        return clientRepository.getAll();
    }

    public Optional<Client> getClient(int id){
        return clientRepository.getClient(id);
    }

    public Client save (Client client){
        if (client.getIdClient() == null){
            return clientRepository.save(client);
        } else {
            Optional<Client> client1 = clientRepository.getClient(client.getIdClient());
            if(!client1.isPresent()){
                return clientRepository.save(client);
            } else {
                return client;
            }
        }
    }

    public Client updateClient(Client client){
        if(client.getIdClient() != null ){
            Optional<Client> g = clientRepository.getClient(client.getIdClient());
            if(!g.isPresent()){
                if(client.getEmail() != null ){
                    g.get().setEmail(client.getEmail());
                }

                if(client.getPassword() != null ){
                    g.get().setPassword(client.getPassword());
                }

                if(client.getName() != null ){
                    g.get().setName(client.getName());
                }

                if(client.getAge() != null ){
                    g.get().setAge(client.getAge());
                }
                return clientRepository.save(g.get());

            }

        }
        return client;
    }

    public boolean deleteClient(int id){
        Boolean d = getClient(id).map(client ->{
            clientRepository.delete(client);
            return true;
        }).orElse(false);
        return d;
    }
}
