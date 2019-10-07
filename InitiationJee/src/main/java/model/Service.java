package model;


import java.util.*;

public class Service {
    private int id;
    private String lib;

    public List<Employe> getEmploye() {
        return employe;
    }

    public void setEmploye(Employe e) {
        List<Employe> employe = new ArrayList<Employe>();
        employe.add(e);
        this.employe = employe;
    }

    private List<Employe> employe = new ArrayList<Employe>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLib() {
        return lib;
    }

    public void setLib(String lib) {
        this.lib = lib;
    }

}