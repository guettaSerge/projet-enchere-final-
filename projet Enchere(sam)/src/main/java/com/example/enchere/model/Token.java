/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.enchere.model;

import java.util.Date;

import com.example.enchere.dao.*;

@TableName(table = "",view="9")   
public class Token extends  AccessBase{
    @Attribute(attrName = "", attrType = "", idPrimaryKey = "")
    private Integer idToken;
    @Attribute(attrName = "", attrType = "", idPrimaryKey = "")
    private String valeurToken;
    @Attribute(attrName = "", attrType = "", idPrimaryKey = "")
    private Date dateExpiration;
    @Attribute(attrName = "", attrType = "", idPrimaryKey = "")
    private Integer idClient;

    public Integer getIdToken() {
        return idToken;
    }

    public void setIdToken(Integer idToken) {
        this.idToken = idToken;
    }

    public String getValeurToken() {
        return valeurToken;
    }

    public void setValeurToken(String valeurToken) {
        this.valeurToken = valeurToken;
    }

    public Date getDateExpiration() {
        return dateExpiration;
    }

    public void setDateExpiration(Date dateExpiration) {
        this.dateExpiration = dateExpiration;
    }

    public Integer getIdClient() {
        return idClient;
    }

    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }

	public Iterable<Token> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}
