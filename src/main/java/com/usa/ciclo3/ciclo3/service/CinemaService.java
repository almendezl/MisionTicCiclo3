package com.usa.ciclo3.ciclo3.service;

import com.usa.ciclo3.ciclo3.model.Category;
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

    public Cinema updateCinema(Cinema cinema){
        if(cinema.getId() != null ){
            Optional<Cinema> g = cinemaRepository.getCinema(cinema.getId());
            if(g.isPresent()){
                if(cinema.getDescription() != null ){
                    g.get().setDescription(cinema.getDescription());
                }

                if(cinema.getName() != null ){
                    g.get().setName(cinema.getName());
                }

                if(cinema.getOwner() != null ){
                    g.get().setOwner(cinema.getOwner());
                }

                if(cinema.getCapacity() != null ){
                    g.get().setCapacity(cinema.getCapacity());
                }
                return cinemaRepository.save(g.get());

            }

        }
        return cinema;
    }
    public boolean deleteCinema(int id){
        Boolean d = getCinema(id).map(cinema ->{
            cinemaRepository.delete(cinema);
            return true;
        }).orElse(false);
        return d;
    }
}
