package com.codecool.web.model;

public class Admin extends AbstractModel {

    private String email;
    private String password;
    private String name;

    public Admin(int id, String email, String password, String name) {
        super(id);
        this.email = email;
        this.password = password;
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }
}
