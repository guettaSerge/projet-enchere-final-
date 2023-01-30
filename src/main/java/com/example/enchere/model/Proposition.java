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
import com.example.enchere.modelAff.ClientSolde;
import com.example.enchere.modelAff.ValeurEnchereMax;
import java.sql.Connection;
import java.util.ArrayList;
@TableName(table = "Proposition",view="9")   
public class Proposition extends AccessBase{
    @Attribute(attrName = "idproposition", attrType = "", idPrimaryKey = "yes")
    private Integer idProposition;
   @Attribute(attrName = "valeur", attrType = "", idPrimaryKey = "")
    private Float valeur;
    @Attribute(attrName = "dateProposition", attrType = "", idPrimaryKey = "")
    private Date dateProposition;
    @Attribute(attrName = "idEnchere", attrType = "", idPrimaryKey = "")
    private Integer idEnchere;
    @Attribute(attrName = "idClient", attrType = "", idPrimaryKey = "")
    private Integer idClient;

    public Integer getIdProposition() {
        return idProposition;
    }

    public void setIdProposition(Integer idProposition) {
        this.idProposition = idProposition;
    }

    public Float getValeur() {
        return valeur;
    }

    public void setValeur(Float valeur) {
        this.valeur = valeur;
    }
    
     public void isSoldSuffisant(Connection con,Float valeur) throws Exception{
         ClientSolde client=new ClientSolde();
         client.setIdClient(this.getIdClient());
         client=(ClientSolde) client.find(con).get(0);
         if((client.getSolde()-valeur)<0)
             throw new Exception("votre solde est insuffisant");
     } 
     public void isValeurSuperieurDernierENchere(Float valeur,Connection con) throws Exception{
          ValeurEnchereMax verif=new ValeurEnchereMax();
        verif.setIdEnchere(this.getIdEnchere());
        ArrayList<ValeurEnchereMax> tabverif=verif.find(con);
        verif=tabverif.get(0);
        double misemax=verif.getValeur();
        if(!(verif.getValeur()<valeur))
            throw new Exception("votre mise est encore inferieur aux proposision maximum qui est "+misemax);
     }
    public void setValeurVerified(Float valeur) throws Exception{
       Connection con =null;
        try{
            con =ConnectionBase.getCon();
            isPositifNumber(valeur);
            isValeurSuperieurDernierENchere(valeur,con);
            isSoldSuffisant(con,valeur);
            this.setValeur(valeur);
       }
       catch(Exception e){
           throw e;
       }
       finally{
            if(con!=null)con.close();
            
       }
       
    }

    public Date getDateProposition() {
        return dateProposition;
    }

    public void setDateProposition(Date dateProposition) {
        this.dateProposition = dateProposition;
    }

    public Integer getIdEnchere() {
        return idEnchere;
    }

    public void setIdEnchere(Integer idEnchere) {
        this.idEnchere = idEnchere;
    }

    public Integer getIdClient() {
        return idClient;
    }

    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }
     public void isPositifNumber(Float number) throws Exception{
    if(number<0)
        throw new Exception("n'entrer que du chiffre positif");
    }
    public static void main(String [] args) throws Exception{
        Proposition prop=new Proposition();
        prop.setIdClient(3);
        prop.setIdEnchere(1);
        float f=(float) 94001.0;
        prop.setValeurVerified(f);
        System.out.println("ok ok");
    }
    
}
