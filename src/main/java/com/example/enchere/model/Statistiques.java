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
    ArrayList<CategoryTopBenefice> topProdBenef;
    ArrayList<CategoryTopChiffreAffaire> topProdChiffAff;
    ArrayList<CategoryVendu> topCategoryVendu;
    ArrayList<ProduitVendu>  produitVendu;

    

    public ArrayList<ProduitVendu> getProduitVendu() {
        return produitVendu;
    }

    public void setProduitVendu(ArrayList<ProduitVendu> produitVendu) {
        this.produitVendu = produitVendu;
    }
    
    
    public ArrayList<Benefice> getBenefice() {
        return benefice;
    }

    public ArrayList<ChiffreAffaire> getChiffreAffaire() {
        return chiffreAffaire;
    }

    public ArrayList<CategoryTopBenefice> getTopProdBenef() {
        return topProdBenef;
    }

    public ArrayList<CategoryTopChiffreAffaire> getTopProdChiffAff() {
        return topProdChiffAff;
    }

    public ArrayList<CategoryVendu> getTopCategoryVendu() {
        return topCategoryVendu;
    }

    public void setBenefice(ArrayList<Benefice> benefice) {
        this.benefice = benefice;
    }

    public void setChiffreAffaire(ArrayList<ChiffreAffaire> chiffreAffaire) {
        this.chiffreAffaire = chiffreAffaire;
    }

    public void setTopProdBenef(ArrayList<CategoryTopBenefice> topProdBenef) {
        this.topProdBenef = topProdBenef;
    }

    public void setTopProdChiffAff(ArrayList<CategoryTopChiffreAffaire> topProdChiffAff) {
        this.topProdChiffAff = topProdChiffAff;
    }

    public void setTopCategoryVendu(ArrayList<CategoryVendu> topCategoryVendu) {
        this.topCategoryVendu = topCategoryVendu;
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
        
        CategoryTopBenefice variable1=new CategoryTopBenefice();
        variable1.setMonth(month);
        variable1.setYears(years);
        this.setTopProdBenef(variable1.find(con));
        
        CategoryTopChiffreAffaire variable2=new CategoryTopChiffreAffaire();
        variable2.setMonth(month);
        variable2.setYears(years);
        this.setTopProdChiffAff(variable2.find(con));
        
        CategoryVendu variable3=new CategoryVendu();
        variable3.setMonth(month);
        variable3.setYears(years);
        this.setTopCategoryVendu(variable3.find(con));
        
        ProduitVendu variable4=new ProduitVendu();
        variable4.setMonth(month);
        variable4.setYears(years);
        this.setProduitVendu(variable4.find(con));
        }
        catch(Exception e){
            throw e;
        }
        finally{
        if(con!=null)con.close();
        }
    }
   
   public String[] getMontYear(){
       int taille=this.benefice.size();
       String[] str=new String[taille];
      for(int i=0;i<taille;i++){
          Benefice b=benefice.get(i);
          str[i]="'"+b.getMonth()+"-"+b.getYears()+"'";
      }
      return str;
   }
   public String[] getBenefices(){
        int taille=this.benefice.size();
       String[] str=new String[taille];
      for(int i=0;i<taille;i++){
          Benefice b=benefice.get(i);
          str[i]="'"+b.getBenefice()+"'";
      }
      return str;
   }
   public String[] getChiffreAffaires(){
        int taille=this.chiffreAffaire.size();
       String[] str=new String[taille];
      for(int i=0;i<taille;i++){
          ChiffreAffaire b=chiffreAffaire.get(i);
          str[i]="'"+b.getChiffreAffaire()+"'";
      }
      return str;
   }
   
   public String[] getProduitVendus(){
        int taille=this.produitVendu.size();
       String[] str=new String[taille];
      for(int i=0;i<taille;i++){
          ProduitVendu b=this.produitVendu.get(i);
          str[i]="'"+b.getNombreProduit()+"'";
      }
      return str;
   }
  

    public static void main(String[]dfgrtg) throws Exception{
    Statistiques stat=new Statistiques();
    stat.find();
    stat.setYears(2023);
    String[] my=stat.getMontYear();
    System.out.println(my[0]);
    }
        
    
}
