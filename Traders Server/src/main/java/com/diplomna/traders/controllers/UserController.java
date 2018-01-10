package com.diplomna.traders.controllers;

import com.diplomna.traders.DTOs.UserDTO;
import com.diplomna.traders.business.logic.UserHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/User")
@RestController
public class UserController {

    @Autowired
    private UserHandler userHandler;

    @RequestMapping("/Create")
    public ResponseEntity<List<UserDTO>> createUser(@RequestBody List<UserDTO> userDTOS){

        userHandler.createNewUser(userDTOS);

        return ResponseEntity.ok(userDTOS);
    }

}
