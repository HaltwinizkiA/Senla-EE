package com.senla.haltvinizki.entity.credentials;

public class Credentials {
    private  int id;
    private  String password;
    private  String login;
    public Credentials(int id, String password, String login) {
        this.id = id;
        this.password = password;
        this.login = login;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getLogin() {
        return login;
    }
}
