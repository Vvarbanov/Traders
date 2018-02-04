package com.diplomna.traders.business.logic;


import com.diplomna.traders.DTOs.UserDTO;
import com.diplomna.traders.Models.User;
import com.diplomna.traders.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserHandler implements UserDetailsService{
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Autowired
    private UserRepository userRepo;
    
    public User registerNewUserAccount(UserDTO accountDto) throws Exception{
        //TODO: sloji proverki dali ne exists username ili mail
        User newUser = new User(accountDto.getUsername(),passwordEncoder.encode(accountDto.getPassword()));
        userRepo.save(newUser);
        return newUser;
    }
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepo.findByUsername(username);
    }
}
