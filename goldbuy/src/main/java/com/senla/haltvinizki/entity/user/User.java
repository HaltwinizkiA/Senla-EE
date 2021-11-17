package com.senla.haltvinizki.entity.user;

import com.senla.haltvinizki.entity.credentials.Credentials;
import com.senla.haltvinizki.entity.role.Role;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @OneToOne(optional = false,fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "credentialsid")
    private Credentials credentials;

    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "roleid")
    private Role role;

    @Column(name = "name")
    private String name;

    @Column(name = "phonenumber")
    private String phoneNumber;

    @Column(name = "mail")
    private String Mail;

    public User() {
    }

    public Credentials getCredentials() {
        return credentials;
    }

    public void setCredentials(Credentials credentials) {
        this.credentials = credentials;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
