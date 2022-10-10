package com.usa.ciclo3.ciclo3.repositorio;

import com.usa.ciclo3.ciclo3.interfaces.ReservationInterface;
import com.usa.ciclo3.ciclo3.model.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class ReservationRepository {

    @Autowired
    private ReservationInterface reservationInterface;

    public List<Reservation> getAll(){
        return (List<Reservation>) reservationInterface.findAll();
    }

    public Optional<Reservation> getReservation(int id){
        return reservationInterface.findById(id);
    }

    public Reservation save(Reservation reservation){
        return reservationInterface.save(reservation);
    }
}
