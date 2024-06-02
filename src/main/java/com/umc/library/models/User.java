package com.umc.library.models;

import java.util.Objects;

public class User {
    private String id;
    private String username;
    private String password;

    public User(String username, String password) {
        setUsername(username);
        setPassword(password);
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUsername(String username) {
        Objects.requireNonNull(username, "Username não pode ser vazio!");
        if (username.isEmpty()) {
            throw new IllegalArgumentException("Username não pode ser vazio!");
        }
        this.username = username;
    }

    public void setPassword(String password) {
        Objects.requireNonNull(password, "Password não pode ser vazio!");
        if (password.isEmpty()) {
            throw new IllegalArgumentException("Password não pode ser vazio!");
        }
        this.password = password;
    }
}
