package com.diplomna.traders.controllers;

import com.diplomna.traders.dtos.CategoryDto;
import com.diplomna.traders.business.logic.CategoryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RequestMapping("/categories")
@RestController
public class CategoryController {

    @Autowired
    private CategoryHandler catHandler;

    @RequestMapping(value = "/create",method = POST)
    public ResponseEntity<List<CategoryDto>> CreateCategory(@RequestBody List<CategoryDto> categoryDto){

        catHandler.createNewCategory(categoryDto);

        return ResponseEntity.ok(categoryDto);
    }
}
