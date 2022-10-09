package com.usa.ciclo3.ciclo3.repository.service;

import com.usa.ciclo3.ciclo3.entities.Cinema;
import com.usa.ciclo3.ciclo3.entities.Product;
import com.usa.ciclo3.ciclo3.repository.CinemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CinemaService {
    @Autowired
    private CinemaRepository cinemaRepository;

    //se hace la logica del negocio, se verifica la infor
    public List<Cinema> getAll(){
        return cinemaRepository.getAll();
    }

    public Optional<Cinema> getCinema(int id){
        return cinemaRepository.getCinema(id);
    }

    public Cinema save(Cinema p){
        if(p.getId() != null){
            Optional<Cinema> e = cinemaRepository.getCinema(p.getId());
            if(e.isPresent()){
                return p;
            }else{
                return cinemaRepository.save(p);
            }

        }else{
            return  cinemaRepository.save(p);
        }

    }

    public Cinema update(Cinema p){
        if(p.getId() != null){
            //si no esta en la db lo guardo
            Optional<Cinema> q = cinemaRepository.getCinema(p.getId());
            if(q.isPresent()){
                if(p.getName() != null){
                    q.get().setName(p.getName());
                }
                if(p.getOwner() != null){
                    q.get().setOwner(p.getOwner());
                }
                if(p.getCapacity() != null){
                    q.get().setCapacity(p.getCapacity());
                }
                if(p.getDescription() != null){
                    q.get().setDescription(p.getDescription());
                }

                if(p.getCategory() != null){
                    q.get().setCategory(p.getCategory());
                }
                 cinemaRepository.save(q.get());
                return q.get();
            }else{
                return p;
            }
        }else{
            return p;
        }
    }

    public boolean delete(int id){
        boolean flag = false;
        Optional<Cinema> p = cinemaRepository.getCinema(id);

        if(p.isPresent()){
            cinemaRepository.delete(p.get());
            flag = true;
        }

        return flag;

    }

}
