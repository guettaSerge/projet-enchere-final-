/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.enchere.model;
import com.example.enchere.dao.*;

import java.sql.Date;
import java.util.ArrayList;

@TableName(table = "TokenClient",view="9")
public class TokenClient extends AccessBase{
    @Attribute(attrName = "idTokenClient", attrType = "", idPrimaryKey = "")
    private Integer idToken;
    @Attribute(attrName = "valeurToken", attrType = "", idPrimaryKey = "")
    private String valeurToken;
    @Attribute(attrName = "dateExpiration", attrType = "dateExpiration", idPrimaryKey = "")
    private Date dateExpiration;
    @Attribute(attrName = "idClient", attrType = "", idPrimaryKey = "")
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

    public Integer setClientByToken() throws Exception {
        this.setValeurToken(valeurToken);
        ArrayList<TokenClient> alltoken=this.find();
        if(alltoken.size()<=0)throw new Exception("token invalide");
        TokenClient client=alltoken.get(0);
        if(client.getDateExpiration().before(new java.util.Date())){
            throw new Exception("token expiré");
        }
        return client.getIdClient();
    }
	public Iterable<TokenClient> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
    public static void main(String [] args) throws Exception {
        int idclient=1;
        String token="rand"+(Math.random()+idclient)+"num";
        Data data=new Data();
        TokenClient tkn=new TokenClient();
        tkn.setValeurToken(token);
        tkn.setIdClient(1);
        java.util.Date now=new java.util.Date();
        now.setDate(now.getDate()+1);
        tkn.setDateExpiration(new Date(now.getTime()));
            tkn.insertBase();
    }
}
