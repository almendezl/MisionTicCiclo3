package com.usa.ciclo3.ciclo3.controller;

import com.usa.ciclo3.ciclo3.model.Category;
import com.usa.ciclo3.ciclo3.model.Cinema;
import com.usa.ciclo3.ciclo3.service.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/Cinema")
public class CinemaController {
    @Autowired
    private CinemaService cinemaService;

    @GetMapping("/all")
    public List<Cinema> getAll(){
        return cinemaService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Cinema> getCinema(@PathVariable("id") int id){
        return cinemaService.getCinema(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Cinema save (@RequestBody Cinema cinema){
        return cinemaService.save(cinema);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Cinema update(@RequestBody Cinema cinema){
        return cinemaService.updateCinema(cinema);

    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return cinemaService.deleteCinema(id);
    }
}
