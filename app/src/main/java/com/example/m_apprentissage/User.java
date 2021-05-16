package com.example.m_apprentissage;

public class User{

    private String prenomUser;
    private String nomUser;
    private String titreUser;
    private String etablissementUser;
    private String courrielUser;
    private String passWordUser;

    public User(){

    }

    public User(String courrielUser){
        this.courrielUser = courrielUser;
    }

    public User(String prenomUser, String nomUser, String titreUser, String etablissementUser, String courrielUser, String passWordUser){
        setPrenomUser(prenomUser);
        this.nomUser = nomUser;
        this.titreUser = titreUser;
        this.etablissementUser = etablissementUser;
        this.courrielUser = courrielUser;
        this.passWordUser = passWordUser;
    }

    public String getPrenomUser() {
        return prenomUser;
    }

    public void setPrenomUser(String prenomUser) {
        this.prenomUser = prenomUser;
    }

    public String getNomUser() {
        return nomUser;
    }

    public void setNomUser(String nomUser) {
        this.nomUser = nomUser;
    }

    public String getTitreUser() {
        return titreUser;
    }

    public void setTitreUser(String titreUser) {
        this.titreUser = titreUser;
    }

    public String getEtablissementUser() {
        return etablissementUser;
    }

    public void setEtablissementUser(String etablissementUser) {
        this.etablissementUser = etablissementUser;
    }

    public String getCourrielUser() {
        return courrielUser;
    }

    public void setCourrielUser(String courrielUser) {
        this.courrielUser = courrielUser;
    }

    public String getPassWordUser() {
        return passWordUser;
    }

    public void setPassWordUser(String passWordUser) {
        this.passWordUser = passWordUser;
    }
}

