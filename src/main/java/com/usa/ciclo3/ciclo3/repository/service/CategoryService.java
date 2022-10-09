package com.usa.ciclo3.ciclo3.repository.service;

import com.usa.ciclo3.ciclo3.entities.Category;
import com.usa.ciclo3.ciclo3.entities.Product;
import com.usa.ciclo3.ciclo3.repository.CategoryRepository;
import com.usa.ciclo3.ciclo3.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    //se hace la logica del negocio, se verifica la infor
    public List<Category> getAll(){
        return categoryRepository.getAll();
    }

    public Optional<Category> getCategory(int id){
        return categoryRepository.getCategory(id);
    }

    public Category save(Category c){
        if(c.getId() != null){
            Optional<Category> e = categoryRepository.getCategory(c.getId());
            if(e.isPresent()){
                return c;
            }else{
                return categoryRepository.save(c);
            }

        }else{
            return  categoryRepository.save(c);
        }

    }

    public Category update(Category c){
        if(c.getId() != null){
            //si no esta en la db lo guardo
            Optional<Category> q = categoryRepository.getCategory(c.getId());
            if(q.isPresent()){
                if(c.getName() != null){
                    q.get().setName(c.getName());
                }


                if(c.getProducts() != null){
                    q.get().setProducts(c.getProducts());
                }
                categoryRepository.save(q.get());
                return q.get();
            }else{
                return c;
            }
        }else{
            return c;
        }
    }

    public boolean delete(int id){
        boolean flag = false;
        Optional<Category> p = categoryRepository.getCategory(id);

        if(p.isPresent()){
            categoryRepository.delete(p.get());
            flag = true;
        }

        return flag;

    }

}
