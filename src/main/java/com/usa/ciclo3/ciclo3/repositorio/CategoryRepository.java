package com.usa.ciclo3.ciclo3.repositorio;

import com.usa.ciclo3.ciclo3.interfaces.CategoryInterface;
import com.usa.ciclo3.ciclo3.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class CategoryRepository {
    @Autowired
    private CategoryInterface categoryInterface;

    public List<Category> getAll(){
        return (List<Category>) categoryInterface.findAll();
    }

    public Optional<Category> getCategory(int id){
        return categoryInterface.findById(id);
    }

    public Category save(Category category){
        return categoryInterface.save(category);
    }

    public void delete (Category category){
        categoryInterface.delete(category);

    }
}
