package com.codecool.web.model;


public class User extends AbstractModel {

    private String email;
    private int credit;
    private String password;
    private boolean isAdmin;


    public User(int userId, int credit, String password, boolean isAdmin) {
        super(userId);
        this.credit = credit;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    public User(String email, int credit, String password, boolean isAdmin) {
        this.email = email;
        this.credit = credit;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User(String email, String password, boolean isAdmin) {
        this.email = email;
        this.password = password;
        this.isAdmin = isAdmin;
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

    public boolean isAdmin() {
        return isAdmin;
    }
}

