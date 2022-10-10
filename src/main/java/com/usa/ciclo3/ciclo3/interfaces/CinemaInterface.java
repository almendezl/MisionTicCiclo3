package com.usa.ciclo3.ciclo3.interfaces;

import com.usa.ciclo3.ciclo3.model.Cinema;
import org.springframework.data.repository.CrudRepository;

public interface CinemaInterface extends CrudRepository<Cinema, Integer> {
}
