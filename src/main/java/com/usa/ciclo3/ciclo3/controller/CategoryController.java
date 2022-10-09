package com.usa.ciclo3.ciclo3.controller;

import com.usa.ciclo3.ciclo3.entities.Category;
import com.usa.ciclo3.ciclo3.entities.Product;
import com.usa.ciclo3.ciclo3.repository.service.CategoryService;
import com.usa.ciclo3.ciclo3.repository.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/all")
    public List<Category> getAll(){
        return  categoryService.getAll();
    }
    @PostMapping("/save")
    public Category save(@RequestBody Category p){
        return categoryService.save(p);
    }
}
