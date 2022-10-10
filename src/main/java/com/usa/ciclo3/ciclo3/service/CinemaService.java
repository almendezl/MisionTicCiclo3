package com.usa.ciclo3.ciclo3.service;

import com.usa.ciclo3.ciclo3.model.Cinema;
import com.usa.ciclo3.ciclo3.repositorio.CinemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CinemaService {
    @Autowired
    private CinemaRepository cinemaRepository;

    public List<Cinema> getAll(){
        return cinemaRepository.getAll();
    }

    public Optional<Cinema> getCinema(int id){
        return cinemaRepository.getCinema(id);
    }

    public Cinema save (Cinema cinema){
        if (cinema.getId() == null){
            return cinemaRepository.save(cinema);
        } else {
            Optional<Cinema> cinema1 = cinemaRepository.getCinema(cinema.getId());
            if(!cinema1.isPresent()){
                return cinemaRepository.save(cinema);
            } else {
                return cinema;
            }
        }
    }
}
