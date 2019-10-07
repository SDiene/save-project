package model;

public class User {
    public String login;
    public String password;
    public String nom;
    public String profile;

    public User(String login, String password, String nom, String profile) {
        this.login = login;
        this.password = password;
        this.nom=nom;
        this.profile=profile;
    }

    public User() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }
}