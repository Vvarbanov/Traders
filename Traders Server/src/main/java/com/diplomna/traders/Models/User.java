package com.diplomna.traders.Models;

import javax.persistence.*;

@Entity
public class User {

    public enum AccountType{
        DEALER,
        CUSTOMER
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "user_name")
    private String username;

    @Column(name = "user_password")
    private String password;

    @Column(name = "user_email")
    private String email;

    @Column(name = "user_phone")
    private String phone;

    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    public User(String username, String password, String email, String phone, AccountType accountType) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.accountType = accountType;
    }

    public User() {}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }
}
