/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.enchere.modelAff;

/**
 *
 * @author P14A-Serge
 */
import com.example.enchere.dao.*;
import com.example.enchere.model.Enchere;
import com.example.enchere.traitement.RechercheMultiParametre;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.util.ArrayList;
@TableName(table = "Enchere",view="vw_EnchereWithStatut")
public class Encheres {
    @Attribute(attrName = "idEnchere", attrType = "", idPrimaryKey = "yes")
    private Integer idEnchere;
    @Attribute(attrName = "nom", attrType = "", idPrimaryKey = "")
    private String nom;
   @Attribute(attrName = "debut", attrType = "", idPrimaryKey = "")
    private Date debut;
   @Attribute(attrName = "duree", attrType = "", idPrimaryKey = "")
    private Time duree;
   @Attribute(attrName = "prixDepart", attrType = "", idPrimaryKey = "")
    private Float prixDepart;
    @Attribute(attrName = "idCategory", attrType = "", idPrimaryKey = "")
    private Integer idCategory;
    @Attribute(attrName = "idClient", attrType = "", idPrimaryKey = "")
    private Integer idClient;
    @Attribute(attrName = "statut", attrType = "", idPrimaryKey = "")
    private Integer statut;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    
    public Integer getStatut() {
        return statut;
    }

    public void setStatut(Integer statut) {
        this.statut = statut;
    }
    
    public Integer getIdEnchere() {
        return idEnchere;
    }

    public void setIdEnchere(Integer idEnchere) {
        this.idEnchere = idEnchere;
    }

    public Date getDebut() {
        return debut;
    }

    public void setDebut(Date debut) {
        this.debut = debut;
    }

    public Time getDuree() {
        return duree;
    }

    public void setDuree(Time duree) {
        this.duree = duree;
    }

    public Float getPrixDepart() {
        return prixDepart;
    }

    public void setPrixDepart(Float prixDepart) {
        this.prixDepart = prixDepart;
    }

    public Integer getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Integer idCategory) {
        this.idCategory = idCategory;
    }

    public Integer getIdClient() {
        return idClient;
    }

    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }
    
    public ArrayList<Encheres> multiCritere(RechercheMultiParametre parametre) throws Exception{
        Connection con=null;
        PreparedStatement stmt=null;
        try{
            con=ConnectionBase.getCon();
            String query="select * from vw_EnchereWithStatutCategorie "+parametre.getConditionMultiCritere();
            stmt=(con.prepareStatement(query));
        	ResultSet res=stmt.executeQuery();
                ArrayList val = new ArrayList();
        	while(res.next()){
        		Encheres encheres=new Encheres();
                         encheres.setIdClient(res.getInt("idClient"));
                         encheres.setIdEnchere(res.getInt("idEnchere"));
                         encheres.setDebut(res.getDate("debut"));
                         encheres.setDuree(res.getTime("duree"));
                         encheres.setPrixDepart(res.getFloat("prixDepart"));
                         encheres.setNom(res.getString("nom"));
                         encheres.setIdCategory(res.getInt("idCategory"));
                         encheres.setStatut(res.getInt("statut"));
        		val.add(encheres);
        	}
             return val;
        }
        catch(Exception e){
            throw e;
        }
        finally {
        	if(stmt!=null)stmt.close();
                if(con!=null)con.close();
        }
        
    }
     public static void main(String[] args) throws Exception{

    }
}