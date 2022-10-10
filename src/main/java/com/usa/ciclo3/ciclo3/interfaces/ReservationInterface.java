package com.usa.ciclo3.ciclo3.interfaces;

import com.usa.ciclo3.ciclo3.model.Reservation;
import org.springframework.data.repository.CrudRepository;

public interface ReservationInterface extends CrudRepository<Reservation, Integer> {
}
