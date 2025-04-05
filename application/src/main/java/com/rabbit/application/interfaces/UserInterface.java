package com.rabbit.application.interfaces;

public interface UserInterface {
    void setId(Long id);
    Long getId();

    void setEmail(String email);
    String getEmail();

    void setPassword(String password);
    String getPassword();

    void setUsername(String username);
    String getUsername();
}
