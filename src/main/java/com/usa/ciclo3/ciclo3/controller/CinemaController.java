package com.usa.ciclo3.ciclo3.controller;

import com.usa.ciclo3.ciclo3.entities.Cinema;
import com.usa.ciclo3.ciclo3.entities.Product;
import com.usa.ciclo3.ciclo3.repository.service.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class CinemaController {
    @Autowired
    private CinemaService cinemaService;

    @GetMapping("/api/Cinema/all")
    public List<Cinema> getAll(){
        return  cinemaService.getAll();
    }
    @PostMapping("/api/Cinema/save")
    public Cinema save(@RequestBody Cinema p){
        return cinemaService.save(p);
    }
}
