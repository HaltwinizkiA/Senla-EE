package com.senla.haltvinizki.entity.credentials;

public class Credentials {
    private final int id;
    private final String password;
    private final String login;

    public Credentials(String password, String login, int id) {
        this.password = password;
        this.login = login;
        this.id = id;
    }
}
