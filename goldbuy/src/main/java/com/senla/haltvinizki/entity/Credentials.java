package com.senla.haltvinizki.entity;

import com.senla.haltvinizki.configuration.GraphConfiguration;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "credentials")
@NamedEntityGraph(name = GraphConfiguration.CREDENTIALS_USER, attributeNodes = @NamedAttributeNode("user"))
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Credentials {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "password")
    private String password;
    @Column(name = "login")
    private String login;
    @OneToOne(optional = false, fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "credentials")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
