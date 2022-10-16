package com.usa.ciclo3.ciclo3.repositorio;

import com.usa.ciclo3.ciclo3.interfaces.CinemaInterface;
import com.usa.ciclo3.ciclo3.model.Cinema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CinemaRepository {
    @Autowired
    private CinemaInterface cinemaInterface;

    public List<Cinema> getAll(){
        return (List<Cinema>) cinemaInterface.findAll();
    }

    public Optional<Cinema> getCinema(int id){
        return cinemaInterface.findById(id);
    }

    public Cinema save(Cinema cinema){
        return cinemaInterface.save(cinema);
    }

    public void delete(Cinema cinema){
        cinemaInterface.delete(cinema);
    }
}
