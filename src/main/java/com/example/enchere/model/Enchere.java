/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.enchere.model;
import com.example.enchere.dao.*;
import com.example.enchere.traitement.RechercheMultiParametre;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.Date;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
@TableName(table = "Enchere",view="9")   
public class Enchere extends AccessBase{
    @Attribute(attrName = "idEnchere", attrType = "", idPrimaryKey = "yes")
    private Integer idEnchere;
    @Attribute(attrName = "nom", attrType = "", idPrimaryKey = "")
    String nom;
    @Attribute(attrName = "descriptions", attrType = "", idPrimaryKey = "")
    String descriptions;
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

    public Time getDuree() {
        return duree;
    }
    
    public void setDuree(Time duree) {
        this.duree = duree;
    }
    public void setDuree(String duree) {
        this.duree = Time.valueOf(duree);
    }

    
    public String getNom() {
        return nom;
    }

    
    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
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
    public String generateSql(){
        String query="insert into Enchere (nom,descriptions,debut,duree,prixDepart,idCategory,idClient) values (";
        query+="'"+this.getNom()+"',";
        query+="'"+this.getDescriptions()+"',";
        query+="'"+this.getDebut().toString()+"',";
        query+="'"+this.getDuree().toString()+"',";
        query+=""+this.getPrixDepart()+",";
        query+=this.getIdCategory()+",";
        query+=this.getIdClient()+")";
      return query;   
    }
    public  void insertionBase(Connection con) throws Exception{
	Statement stmt=null;
       try {
    	
       	stmt=con.createStatement();
        stmt.executeUpdate(this.generateSql());
       }
       catch(Exception e){
       	throw e;
       }
       finally {
       	if(stmt!=null)stmt.close();
       }
    }
    public  void insertionBase() throws Exception{
		Connection con=null;
       try {
    	con=ConnectionBase.getCon();
       this.insertionBase(con);
       con.commit();
       }
       catch(Exception e){
           con.rollback();
       	throw e;
       }
       finally {
       	if(con!=null)con.close();
       }
    }
    public static void main(String[] args) throws Exception{
        Enchere ench=new Enchere();
        ench.setIdClient(1);
       ArrayList<Enchere> enchere=ench.find();
        System.out.println("ok");
    }
}
