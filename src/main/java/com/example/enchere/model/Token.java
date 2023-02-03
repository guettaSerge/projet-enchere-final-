/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.enchere.model;


import com.example.enchere.dao.*;

import java.sql.Date;
import java.util.ArrayList;

@TableName(table = "TokenAdmin",view="9")   
public class Token extends AccessBase{
    @Attribute(attrName = "idTokenAdmin", attrType = "", idPrimaryKey = "")
    private Integer idToken;
    @Attribute(attrName = "ValeurToken", attrType = "", idPrimaryKey = "")
    private String valeurToken;
    @Attribute(attrName = "DateExpiration", attrType = "", idPrimaryKey = "")
    private Date dateExpiration;
    @Attribute(attrName = "adminidadmin", attrType = "", idPrimaryKey = "")
    private Integer idAdmin;

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

    public Integer getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(Integer idAdmin) {
        this.idAdmin = idAdmin;
    }

    public Integer setClientByToken() throws Exception {
        this.setValeurToken(valeurToken);
        ArrayList<Token> alltoken=this.find();
        if(alltoken.size()<=0)throw new Exception("token invalide");
        Token client=alltoken.get(0);
        if(client.getDateExpiration().before(new java.util.Date())){
            throw new Exception("token expiré");
        }
        return client.getIdAdmin();
    }
	public Iterable<Token> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
    public static void main(String[] args) throws Exception {
        Token token =new Token();
        token.setIdAdmin(1);
        token.setValeurToken("dfsffdsf");
        token.setDateExpiration(Date.valueOf("2022-01-11"));
        token.insertBase();
    }
}
