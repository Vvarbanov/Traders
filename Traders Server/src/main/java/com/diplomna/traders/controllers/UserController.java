package com.diplomna.traders.controllers;

import com.diplomna.traders.dtos.ErrorDTO;
import com.diplomna.traders.dtos.UserDTO;
import com.diplomna.traders.business.logic.UserHandler;
import com.diplomna.traders.exceptions.AbstractRestException;
import com.diplomna.traders.exceptions.UserNotFoundException;
import com.diplomna.traders.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/users")
@RestController
public class UserController {

    @Autowired
    private UserHandler userHandler;

    @RequestMapping("/register")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTOS) throws Exception {
        try {
            if (userHandler.registerNewUserAccount(userDTOS) != null) {
                return ResponseEntity.ok(userDTOS);
            } else {
                throw new AbstractRestException("User already exists");
            }
        } catch (AbstractRestException e) {
            ErrorDTO err = new ErrorDTO();
            err.setMessage(e.getMessage());
            return new ResponseEntity(err,HttpStatus.INTERNAL_SERVER_ERROR);
        }catch (Exception e){
            ErrorDTO err = new ErrorDTO();
            err.setMessage(e.getMessage());
            return new ResponseEntity(err,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @RequestMapping("/byUsername")
    public ResponseEntity getAllByUsername(@PathVariable String username) {
        User result;
    
        try {
            result = userHandler.getByUsername(username);
        } catch (UserNotFoundException ex) {
            ErrorDTO error = new ErrorDTO();
            error.setMessage(ex.getMessage());
    
            return ResponseEntity.badRequest().body(error);
        }
    
        return ResponseEntity.ok(result);
    }
}
