package com.senla.haltvinizki.entity.credentials;

import com.senla.haltvinizki.entity.user.User;

import javax.persistence.*;

@Entity
@Table(name = "credentials")
public class Credentials {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "password")
    private String password;
    @Column(name = "login")
    private String login;

    @OneToOne (optional=false, mappedBy="role")
    private User user;

    public Credentials() {
    }

    public Credentials(int id, String password, String login) {
        this.id = id;
        this.password = password;
        this.login = login;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
