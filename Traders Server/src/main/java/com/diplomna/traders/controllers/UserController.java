package com.diplomna.traders.Controllers;

import com.diplomna.traders.DTOs.ErrorDTO;
import com.diplomna.traders.DTOs.UserDTO;
import com.diplomna.traders.business.Logic.UserHandler;
import com.diplomna.traders.Exceptions.AbstractRestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
