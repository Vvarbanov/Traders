package com.diplomna.traders.DTOs;

import com.diplomna.traders.Models.User;

public class UserDTO {

    private String username;
    private String password;
    private String email;
    private String phone;
    private User.AccountType accountType;

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getUsername() {
        return username;
    }

    public User.AccountType getAccountType() {
        return accountType;
    }
}
