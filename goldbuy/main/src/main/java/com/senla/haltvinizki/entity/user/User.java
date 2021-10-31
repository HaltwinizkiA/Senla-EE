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



    public User(int id, Credentials credentials, Role role, String name, String phoneNumber, String mail) {
        this.id = id;
        this.credentials = credentials;
        this.role = role;
        this.name = name;
        this.phoneNumber = phoneNumber;
        Mail = mail;
    }


}
