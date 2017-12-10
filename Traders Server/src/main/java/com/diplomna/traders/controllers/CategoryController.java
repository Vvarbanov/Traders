package com.diplomna.traders.controllers;

import com.diplomna.traders.DTOs.CategoryDTO;
import com.diplomna.traders.Models.Category;
import com.diplomna.traders.business.logic.CategoryHandler;
import com.diplomna.traders.repository.CategoryRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RequestMapping("/Category")
@RestController

public class CategoryController {

    @Autowired
    private CategoryHandler catHandler;
        private ObjectMapper mapper = new ObjectMapper();

        @RequestMapping(value = "/Create",method = POST)
        public String CreateCategory(@RequestBody CategoryDTO categoryDTO){

            catHandler.createNewCategory(categoryDTO.getName());

//        String result = null;
//
//        try {
//            result = mapper.writeValueAsString(categoryDTO);
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }
//
//        return result;
            return "1";
    }


}
