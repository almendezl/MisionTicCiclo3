package com.usa.ciclo3.ciclo3.repositorio;

import com.usa.ciclo3.ciclo3.interfaces.ReservationInterface;
import com.usa.ciclo3.ciclo3.model.Client;
import com.usa.ciclo3.ciclo3.model.Message;
import com.usa.ciclo3.ciclo3.model.Reservation;
import com.usa.ciclo3.ciclo3.model.personalizado.CountClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
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

    public void delete(Reservation reservation){
        reservationInterface.delete(reservation);
    }

    public List<CountClient> getTopClients(){
        List<CountClient> resultado = new ArrayList<>();
        List<Object[]> report = reservationInterface.countTotalReservationsByClient();

        for(int i =0; i< report.size(); i++){
            resultado.add(new CountClient((Long)report.get(i)[1], (Client)report.get(i)[0]));
        }
        return resultado;
    }

    public List<Reservation> getReservationPeriod (Date a, Date b){
        return reservationInterface.findAllByStartDateAfterAndStartDateBefore(a, b);
    }

    public List<Reservation> getReservationByStatus (String status){
        return reservationInterface.findAllByStatus(status);
    }
}
