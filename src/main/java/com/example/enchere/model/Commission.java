/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.enchere.model;

import com.example.enchere.dao.AccessBase;
import com.example.enchere.dao.Attribute;
import com.example.enchere.dao.TableName;
import java.util.ArrayList;


/**
 *
 * @author pc
 */
@TableName(table = "Commission",view="9")
public class Commission extends AccessBase{
    @Attribute(attrName = "idCommission", attrType = "", idPrimaryKey = "yes")
    private Integer idCommission;
    
    @Attribute(attrName = "pourcentage", attrType = "", idPrimaryKey = "")
    private Float pourcentage;

    public Integer getIdCommission() {
        return idCommission;
    }

    public void setIdCommission(Integer idCommission) {
        this.idCommission = idCommission;
    }

    public Float getPourcentage() {
        return pourcentage;
    }

    public void setPourcentage(Float pourcentage) {
        this.pourcentage = pourcentage;
    }
    
     public static void main(String[] args) throws Exception{
        Commission ench=new Commission();
        ArrayList<Commission> enchere=ench.find();
        System.out.println("ok");
        
        Commission c=new Commission();
        c.setPourcentage((float)0.2);
        c.insertBase();
    }
    
}
