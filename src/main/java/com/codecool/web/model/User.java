package com.codecool.web.model;


public class User extends AbstractModel {

    private String email;
    private int credit;
    private String password;
    private String name;


    public User(int userId, int credit, String password) {
        super(userId);
        this.credit = credit;
        this.password = password;
    }

    public User(String email, int credit, String password ) {
        this.email = email;
        this.credit = credit;
        this.password = password;
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User(String email, String name, String password, int credit) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.credit = credit;
    }

    public String getEmail() {
        return email;
    }

    public int getCredit() {
        return credit;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }
}

