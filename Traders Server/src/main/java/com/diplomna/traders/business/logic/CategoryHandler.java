package com.diplomna.traders.business.logic;

import com.diplomna.traders.dtos.CategoryDto;
import com.diplomna.traders.models.Category;
import com.diplomna.traders.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoryHandler {

    @Autowired
    private CategoryRepository categoryRepository;

    public void createNewCategory(List<CategoryDto> categoryDtos){

        if(categoryDtos != null) {
            for (CategoryDto categoryDto : categoryDtos) {
                Category category = new Category();
                category.setName(categoryDto.getName());
                category.setLevel(categoryDto.getLevel());

                categoryRepository.save(category);
            }
        }
    }
}
