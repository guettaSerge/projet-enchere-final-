/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.enchere.traitement;

import com.example.enchere.dao.Useful;
import java.util.Date;


/**
 *
 * @author P14A-Serge
 */
public class RechercheMultiParametre {
    private String motClef;
    private Date[] intervalle;
    private Double[] prixObjet;
    private boolean statut=false;

    public String getMotClef() {
        return motClef;
    }
    public String getMotClefCondition(){
        return " and nom like '%"+motClef+"%' ";
    }
    public void setMotClef(String motClef) {
        try {
            this.motClef = motClef;
        }
        catch (Exception e){

        }
    }

    public Date[] getIntervalle() {
        return intervalle;
    }
    public String getIntervalleCondition(){
        String rep="";
        try{
           rep+=" debut>'"+intervalle[0].toString()+"' ";
        }
        catch(Exception e){   }
        try{
            String and="";
            if (!rep.equals("")) and=" and ";
            rep+=and+" debut<'"+intervalle[1].toString()+"' ";;
        }
        catch(Exception e){   }
       
        if(!rep.equals(""))return " and ("+rep+") ";
        return "";
    }
    public void setIntervalle(Date[] intervalle) {
        this.intervalle = intervalle;
    }

    public Double[] getPrixObjet() {
        return prixObjet;
    }
    public String getPrixObjetCondition(){
        String rep="";
        try{
            rep+=" prixDepart>"+prixObjet[0].toString()+" ";
        }
        catch(Exception e){   }
        try{
            String and="";
            if (!rep.equals("")) and=" and ";
            rep+=and+" prixDepart<"+prixObjet[1].toString()+" ";;
        }
        catch(Exception e){}
       
       if(!rep.equals(""))return " and ("+rep+") ";
        return "";
    }
    
    public void setPrixObjet(Double[] prixObjet) {
        this.prixObjet = prixObjet;
    }

    public boolean isStatut() {
        
        return statut;
    }
    public String isFinished(){
        if(statut)return "(statut=1)";
        else return "(statut=0)";
    }
    public void setStatut(int statut) {

        this.statut = statut==1;
    }
    public String setDateToSqlString(Date date){
        int y=date.getYear();
        String year=(y)+"";
        String month=(date.getMonth())+"";
        String d=date.getDate()+"";
        return year+"-"+month+"-"+d;
    }
    public String getConditionMultiCritere(){
        String critere=" where "+isFinished()+getIntervalleCondition()+getPrixObjetCondition();
        if(motClef!=null) critere+=this.getMotClefCondition();
        return critere;
    }
    public static void main(String[] args) throws Exception{
     RechercheMultiParametre critere=new RechercheMultiParametre();
     critere.setMotClef("e");
     Date[] dt={null,Useful.stringToDate("2000/01/01")};
     critere.setIntervalle(dt);
     Double[] prix={new Double(12.0),new Double(100.0)};
     //critere.setPrixObjet(prix);
     critere.setStatut(1);
     
     String condition="select * from vw_EnchereWithStatutCategorie "+critere.getConditionMultiCritere();
     System.out.println(condition);
     
    }
}
