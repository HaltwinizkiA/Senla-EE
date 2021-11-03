package com.senla.haltvinizki.entity.user;

import com.senla.haltvinizki.entity.credentials.Credentials;
import com.senla.haltvinizki.entity.role.Role;

public class User {
    private final int id;
    private final Credentials credentials;
    private Role role;
    private String name;
    private String phoneNumber;
    private String Mail;

    public int getId() {
        return id;
    }

    public Credentials getCredentials() {
        return credentials;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMail() {
        return Mail;
    }

    public void setMail(String mail) {
        Mail = mail;
    }

    public User(int id, Credentials credentials, Role role, String name, String phoneNumber, String mail) {
        this.id = id;
        this.credentials = credentials;
        this.role = role;
        this.name = name;
        this.phoneNumber = phoneNumber;
        Mail = mail;
    }


}
