package com.diplomna.traders.business.logic;

import com.diplomna.traders.DTOs.CategoryDTO;
import com.diplomna.traders.Models.Category;
import com.diplomna.traders.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoryHandler {

    @Autowired
    private CategoryRepository categoryRepository;

    public void createNewCategory(List<CategoryDTO> categoryDTOs){

        if(categoryDTOs != null) {
            for (CategoryDTO categoryDTO : categoryDTOs) {
                Category category = new Category();
                category.setName(categoryDTO.getName());
                category.setLevel(categoryDTO.getLevel());

                categoryRepository.save(category);
            }
        }
    }
}
