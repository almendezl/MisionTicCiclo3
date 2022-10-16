package com.usa.ciclo3.ciclo3.service;

import com.usa.ciclo3.ciclo3.model.Message;
import com.usa.ciclo3.ciclo3.model.Reservation;
import com.usa.ciclo3.ciclo3.model.personalizado.CountClient;
import com.usa.ciclo3.ciclo3.model.personalizado.StatusAmount;
import com.usa.ciclo3.ciclo3.repositorio.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

    public Reservation updateReservation(Reservation reservation){
        if(reservation.getIdReservation() != null ){
            Optional<Reservation> g = reservationRepository.getReservation(reservation.getIdReservation());
            if(g.isPresent()){
                if(reservation.getStartDate() != null ){
                    g.get().setStartDate(reservation.getStartDate());
                }
                if(reservation.getDevolutionDate() != null ){
                    g.get().setDevolutionDate(reservation.getDevolutionDate());
                }

                if(reservation.getStatus() != null ){
                    g.get().setStatus(reservation.getStatus());
                }



                return reservationRepository.save(g.get());

            }

        }
        return reservation;
    }

    public boolean deleteReservation(int id){
        Boolean d = getReservation(id).map(reservation ->{
            reservationRepository.delete(reservation);
            return true;
        }).orElse(false);
        return d;
    }

    public List<CountClient> getTopClients(){
      return  reservationRepository.getTopClients();
    }

    public StatusAmount getReservationStatusReport (){
        List<Reservation> completed = reservationRepository.getReservationByStatus("completed");
        List<Reservation> cancelled = reservationRepository.getReservationByStatus("cancelled");
        return new StatusAmount(completed.size(), cancelled.size());
    }

    public List<Reservation> getReservationPeriod(String dateA, String dateB){

        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
        Date a = new Date();
        Date b = new Date();

        try{
            a = parser.parse(dateA);
            b = parser.parse(dateB);
        }catch (Exception e){
            e.printStackTrace();
        }

        if(a.before(b)){
            return reservationRepository.getReservationPeriod(a, b);
        }else{
            return new ArrayList<>();
        }



    }
}
