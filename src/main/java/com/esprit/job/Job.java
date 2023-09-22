package com.esprit.job;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Job implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    private String service,nom;
    private Boolean etat;

    public Job() {
    }

    public Job(String service, String nom, Boolean etat) {
        this.service = service;
        this.nom = nom;
        this.etat = etat;
    }

    public int getId() {
        return id;
    }


    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Boolean getEtat() {
        return etat;
    }

    public void setEtat(Boolean etat) {
        this.etat = etat;
    }
}
