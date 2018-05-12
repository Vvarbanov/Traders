package com.diplomna.traders.Controllers;

import com.diplomna.traders.DTOs.CategoryDTO;
import com.diplomna.traders.business.Logic.CategoryHandler;
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
    public ResponseEntity<List<CategoryDTO>> CreateCategory(@RequestBody List<CategoryDTO> categoryDTO){

        catHandler.createNewCategory(categoryDTO);

        return ResponseEntity.ok(categoryDTO);
    }
}
