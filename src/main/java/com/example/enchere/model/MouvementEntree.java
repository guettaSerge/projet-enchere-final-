/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.enchere.model;
import java.util.Date;


/**
 *
 * @author pc
 */
import com.example.enchere.dao.*;
import java.util.ArrayList;
@TableName(table = "MouvementEntree",view="9")   
public class MouvementEntree extends AccessBase{
    @Attribute(attrName = "idMouvementEntree", attrType = "", idPrimaryKey = "")
    private Integer idMouvementEntree;
   @Attribute(attrName = "valeur", attrType = "", idPrimaryKey = "")
    private Float valeur;
    //@Attribute(attrName = "date", attrType = "", idPrimaryKey = "")
    //private Date date;
   @Attribute(attrName = "idClient", attrType = "", idPrimaryKey = "")
    private Integer idClient;
   
   @Attribute(attrName = "adminidadmin", attrType = "", idPrimaryKey = "")
    private Integer idAdmin;
   
   
    public Integer getIdMouvementEntree() {
        return idMouvementEntree;
    }

    public void setIdMouvementEntree(Integer idMouvementEntree) {
        this.idMouvementEntree = idMouvementEntree;
    }

    public Float getValeur() {
        return valeur;
    }

    public void setValeur(Float valeur) throws Exception {
        isPositifNumber(valeur);
        this.valeur = valeur;
    }

    /*public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }*/

    public Integer getIdClient() {
        return idClient;
    }

    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }

    public Integer getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(Integer idAdmin) {
        this.idAdmin = idAdmin;
    }
    public void isPositifNumber(Float number) throws Exception{
    if(number<0)
        throw new Exception("n'entrer que du chiffre positif");
    }
    
    public static void main(String[] args) throws Exception{
        MouvementEntree ench=new MouvementEntree();
        ArrayList<MouvementEntree> enchere=ench.find();
        System.out.println("ok");
        
        MouvementEntree c=new MouvementEntree();
        c.setIdClient(1);
        c.setValeur((float) 1000000000);
        c.insertBase();
    }
}
