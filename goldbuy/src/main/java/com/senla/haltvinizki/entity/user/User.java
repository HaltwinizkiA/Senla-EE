package com.senla.haltvinizki.entity.user;

import com.senla.haltvinizki.entity.credentials.Credentials;
import com.senla.haltvinizki.entity.role.Role;

public class User {
    private final int id;
    private final int credentialsId;
    private int roleId;
    private String name;
    private String phoneNumber;
    private String Mail;

    public User(int id, int credentialsId, int roleId, String name, String phoneNumber, String mail) {
        this.id = id;
        this.credentialsId = credentialsId;
        this.roleId = roleId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        Mail = mail;
    }

    public int getId() {
        return id;
    }

    public int getCredentials() {
        return credentialsId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
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


}
