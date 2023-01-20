package com.example.enchere.modelAff;

import com.example.enchere.dao.AccessBase;
import com.example.enchere.dao.Attribute;
import com.example.enchere.dao.TableName;

@TableName(table = "Client",view="vw_ficheMonetaireClient")
public class ClientSolde extends AccessBase {
    @Attribute(attrName = "idAdmin", attrType = "", idPrimaryKey = "yes")
    private Integer idClient;
    @Attribute(attrName = "nom", attrType = "", idPrimaryKey = "")
    private String nom;
    @Attribute(attrName = "email", attrType = "", idPrimaryKey = "")
    private String email;
    @Attribute(attrName = "passe", attrType = "", idPrimaryKey = "")
    private String passe;
    @Attribute(attrName = "argententrant", attrType = "", idPrimaryKey = "")
    Float argententrant ;
    @Attribute(attrName = "argentsortant", attrType = "", idPrimaryKey = "")
    Float argentsortant ;
    @Attribute(attrName = "argentbloquee", attrType = "", idPrimaryKey = "")
    Float argentbloquee ;


    public Integer getIdClient() {
        return idClient;
    }

    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasse() {
        return passe;
    }

    public void setPasse(String passe) {
        this.passe = passe;
    }

    public Float getArgententrant() {
        return argententrant;
    }

    public void setArgententrant(Float argententrant) {
        this.argententrant = argententrant;
    }

    public Float getArgentsortant() {
        return argentsortant;
    }

    public void setArgentsortant(Float argentsortant) {
        this.argentsortant = argentsortant;
    }

    public Float getArgentbloquee() {
        return argentbloquee;
    }

    public void setArgentbloquee(Float argentbloquee) {
        this.argentbloquee = argentbloquee;
    }

}