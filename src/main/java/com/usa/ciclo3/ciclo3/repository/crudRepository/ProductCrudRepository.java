package com.usa.ciclo3.ciclo3.repository.crudRepository;

import com.usa.ciclo3.ciclo3.entities.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductCrudRepository extends CrudRepository<Product, Integer> {
}
