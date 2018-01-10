package com.diplomna.traders.business.logic;

import com.diplomna.traders.DTOs.UserDTO;
import com.diplomna.traders.Models.User;
import com.diplomna.traders.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserHandler {

    @Autowired
    private UserRepository userDetailsRepository;

    public void createNewUser(List<UserDTO> userDTOS){

        if(userDTOS!=null){
            for(UserDTO userDTO:userDTOS){
                User user =  new User();
                user.setUsername(userDTO.getUsername());
                user.setPassword(userDTO.getPassword());
                user.setEmail(userDTO.getEmail());
                user.setPhone(userDTO.getPhone());
                user.setAccountType(userDTO.getAccountType());
                userDetailsRepository.save(user);
            }
        }
    }
}
