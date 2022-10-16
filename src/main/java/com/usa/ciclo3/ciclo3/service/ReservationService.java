package com.usa.ciclo3.ciclo3.service;

import com.usa.ciclo3.ciclo3.model.Reservation;
import com.usa.ciclo3.ciclo3.repositorio.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAll(){
        return reservationRepository.getAll();
    }

    public Optional<Reservation> getReservation(int id){
        return reservationRepository.getReservation(id);
    }

    public Reservation save (Reservation reservation){
        if (reservation.getIdReservation() == null){
            return reservationRepository.save(reservation);
        } else {
            Optional<Reservation> reservation1 = reservationRepository.getReservation(reservation.getIdReservation());
            if(!reservation1.isPresent()){
                return reservationRepository.save(reservation);
            } else {
                return reservation;
            }
        }
    }

    public boolean deleteReservation(int id){
        Boolean d = getReservation(id).map(reservation ->{
            reservationRepository.delete(reservation);
            return true;
        }).orElse(false);
        return d;
    }
}
