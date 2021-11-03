package com.senla.haltvinizki.entity.credentials;

public class Credentials {
    private final int id;
    private final String password;
    private final String login;

    public int getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getLogin() {
        return login;
    }

    public Credentials(String password, String login, int id) {
        this.password = password;
        this.login = login;
        this.id = id;
    }
}
