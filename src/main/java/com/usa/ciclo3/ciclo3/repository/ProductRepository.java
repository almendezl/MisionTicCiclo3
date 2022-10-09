package com.usa.ciclo3.ciclo3.repository;

import com.usa.ciclo3.ciclo3.entities.Product;
import com.usa.ciclo3.ciclo3.repository.crudRepository.ProductCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class ProductRepository {
    @Autowired
    private ProductCrudRepository productCrudRepository;

    public List<Product> getAll(){
        return (List<Product>) productCrudRepository.findAll();
    }

    public Optional<Product>  getProduct(int id){
        return productCrudRepository.findById(id);
    }

    public Product save(Product p){
        //si existe lo actualiza, si no exisate lo guarda
        return productCrudRepository.save(p);
    }

    public void delete(Product p){
        productCrudRepository.delete(p);
    }
}
