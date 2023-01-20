package com.example.enchere.model;

import com.example.enchere.dao.*;
import com.example.enchere.modelAff.*;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class Statistiques {
    Integer month;
    Integer years;

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getYears() {
        return years;
    }

    public void setYears(Integer years) {
        this.years = years;
    }
    ArrayList<Benefice> benefice;
    ArrayList<ChiffreAffaire> chiffreAffaire;
    ArrayList<ProduitTopBenefice> topProdBenef;
    ArrayList<ProduitTopChiffreAffaire> topProdChiffAff;
    ArrayList<ProduitVendu> topProduitVendu;

    public ArrayList<Benefice> getBenefice() {
        return benefice;
    }

    public ArrayList<ChiffreAffaire> getChiffreAffaire() {
        return chiffreAffaire;
    }

    public ArrayList<ProduitTopBenefice> getTopProdBenef() {
        return topProdBenef;
    }

    public ArrayList<ProduitTopChiffreAffaire> getTopProdChiffAff() {
        return topProdChiffAff;
    }

    public ArrayList<ProduitVendu> getTopProduitVendu() {
        return topProduitVendu;
    }

    public void setBenefice(ArrayList<Benefice> benefice) {
        this.benefice = benefice;
    }

    public void setChiffreAffaire(ArrayList<ChiffreAffaire> chiffreAffaire) {
        this.chiffreAffaire = chiffreAffaire;
    }

    public void setTopProdBenef(ArrayList<ProduitTopBenefice> topProdBenef) {
        this.topProdBenef = topProdBenef;
    }

    public void setTopProdChiffAff(ArrayList<ProduitTopChiffreAffaire> topProdChiffAff) {
        this.topProdChiffAff = topProdChiffAff;
    }

    public void setTopProduitVendu(ArrayList<ProduitVendu> topProduitVendu) {
        this.topProduitVendu = topProduitVendu;
    }
    
   public void find() throws Exception{
        Connection con=ConnectionBase.getCon();
        try{
            Benefice benef=new Benefice();
        benef.setMonth(month);
        benef.setYears(years);
        this.setBenefice(benef.find(con));
        
        ChiffreAffaire variable=new ChiffreAffaire();
        variable.setMonth(month);
        variable.setYears(years);
        this.setChiffreAffaire(variable.find(con));
        
        ProduitTopBenefice variable1=new ProduitTopBenefice();
        variable1.setMonth(month);
        variable1.setYears(years);
        this.setTopProdBenef(variable1.find(con));
        
        ProduitTopChiffreAffaire variable2=new ProduitTopChiffreAffaire();
        variable2.setMonth(month);
        variable2.setYears(years);
        this.setTopProdChiffAff(variable2.find(con));
        
        ProduitVendu variable3=new ProduitVendu();
        variable3.setMonth(month);
        variable3.setYears(years);
        this.setTopProduitVendu(variable3.find(con));
        }
        catch(Exception e){
            throw e;
        }
        finally{
        if(con!=null)con.close();
        }
    }
    public static void main(String[]dfgrtg) throws Exception{
    Statistiques stat=new Statistiques();
    stat.setMonth(1);
    stat.setYears(1);
    stat.find();
    System.out.println("hahaha");
    }
        
    
}
