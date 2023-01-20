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
@TableName(table = "-",view="vw_beneficeMensuel")
public class Benefice extends AccessBase{

    public Double getBenefice() {
        return benefice;
    }

    public void setBenefice(Double benefice) {
        this.benefice = benefice;
    }
     @Attribute(attrName = "benefice", attrType = "", idPrimaryKey = "")
    private Double benefice;
    @Attribute(attrName = "months", attrType = "", idPrimaryKey = "")
    private Integer month;
    @Attribute(attrName = "years", attrType = "", idPrimaryKey = "")
    private Integer years;


    

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
