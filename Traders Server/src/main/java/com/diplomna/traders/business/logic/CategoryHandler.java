package com.diplomna.traders.business.logic;

import com.diplomna.traders.Models.Category;
import com.diplomna.traders.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CategoryHandler {

    @Autowired
    private CategoryRepository categoryRepository;

    public void createNewCategory(String name){

        Category cat =  new Category();
        cat.setName(name);

        categoryRepository.save(cat);

    }
}
