/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.enchere.modelAff;

import com.example.enchere.dao.AccessBase;
import com.example.enchere.dao.Attribute;
import com.example.enchere.dao.TableName;

/**
 *
 * @author P14A-Serge
 */
@TableName(table = "-",view="vw_ProduitVendu")
public class ProduitVendu extends AccessBase{
     @Attribute(attrName = "nombreProduit", attrType = "", idPrimaryKey = "")
    private Integer nombreProduit;
    @Attribute(attrName = "months", attrType = "", idPrimaryKey = "")
    private Integer month;
    @Attribute(attrName = "years", attrType = "", idPrimaryKey = "")
    private Integer years;

    public Integer getNombreProduit() {
        return nombreProduit;
    }

    public void setNombreProduit(Integer nombreProduit) {
        this.nombreProduit = nombreProduit;
    }

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
    

    
}
