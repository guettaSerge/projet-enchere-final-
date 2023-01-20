/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.enchere.controller;

import org.springframework.web.bind.annotation.*;

import com.example.enchere.model.Data;
import com.example.enchere.model.Token;

import java.sql.Date;

/**
 *
 * @author pc
 */
@CrossOrigin(origins="*",allowedHeaders="*")
@RestController
@RequestMapping("/venteenchere")
public class TokenController {
    // creating a get mapping that retrieves all the Marques detail from the
    // database
    @GetMapping("/token")
    private Data getAllToken() {
        Data data = new Data();
        try {
            Token tkn=new Token();
            data.setData(tkn.find());
        } catch (Exception e) {
            data.setError(e);
        }
        return data;
    }

    // creating a get mapping that retrieves the detail of a specific marque
    @GetMapping("/token/{token_id}")
    private Data getToken(@PathVariable("token_id") int token_id) {
        Data data = new Data();
        try {
            Token tkn=new Token();
            tkn.setIdToken(token_id);
            data.setData(tkn.find());
        } catch (Exception e) {
            data.setError(e);
        }
        return data;
    }

    // creating a delete mapping that deletes a specified marque
    @DeleteMapping("/token/{token_id}")
    private void deleteBook(@PathVariable("token_id") int token_id) {
        Token tkn=new Token();
        tkn.setIdToken(token_id);
        try {
            tkn.deleteBase();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // creating post mapping that post the marque detail in the database
    @PostMapping("/Token")
    private int saveToken(@RequestParam String valeur,@RequestParam int idClient,@RequestParam String date) {
        Token tkn=new Token();
        tkn.setValeurToken(valeur);
        tkn.setIdClient(idClient);
        tkn.setDateExpiration(Date.valueOf(date));
        try {
            tkn.insertBase();
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    // creating put mapping that updates the marque detail
    @PutMapping("/Token")
    private int updateToken(@RequestParam int idToken,@RequestParam String valeur,@RequestParam int idClient,@RequestParam String date) {
        Token tkn=new Token();
        tkn.setIdToken(idToken);
        tkn.setValeurToken(valeur);
        tkn.setIdClient(idClient);
        tkn.setDateExpiration(Date.valueOf(date));
        try {
            tkn.insertBase();
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }
}