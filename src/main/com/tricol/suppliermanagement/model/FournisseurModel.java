package com.tricol.suppliermanagement.model;

import jakarta.persistence.*;

@Entity
@Table(name = "fornisseur")
public class FournisseurModel {

    @Id
    private String id;
    private String ICE;
    private String societe;
    private String adresse;
    private String contact;
    private String email;
    private String ville;

    public String getICE() {
        return ICE;
    }

    public void setICE(String ICE) {
        this.ICE = ICE;
    }

    public String getSociete() {
        return societe;
    }

    public void setSociete(String societe) {
        this.societe = societe;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
