package com.usa.ciclo3.ciclo3.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "client")
public class Client implements Serializable{
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer idClient;
        private String name;

        private String email;
        private String password;
        private Integer age;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    @JsonIgnoreProperties("products")
    private Message message;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    @JsonIgnoreProperties("products")
    private Reservation reservation;

    public Integer getIdClient() {
        return idClient;
    }

    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }
}
