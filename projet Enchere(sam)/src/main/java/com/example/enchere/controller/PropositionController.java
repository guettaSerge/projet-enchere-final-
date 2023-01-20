/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.enchere.controller;

import com.example.enchere.dao.Attribute;
import com.example.enchere.model.Produit;
import org.springframework.web.bind.annotation.*;

import com.example.enchere.model.Data;
import com.example.enchere.model.Proposition;
import java.util.Date;

/**
 *
 * @author pc
 */
@CrossOrigin(origins="*",allowedHeaders="*")
@RestController
@RequestMapping("/venteenchere")
public class PropositionController {


    // creating a get mapping that retrieves all the Marques detail from the
    // database
    @GetMapping("/proposition")
    private Data getAllProposition() {
        Data data = new Data();
        try {
            data.setData(new Proposition().find());
        } catch (Exception e) {
            data.setError(e);
        }
        return data;
    }

    // creating a get mapping that retrieves the detail of a specific marque
    @GetMapping("/proposition/{proposition_id}")
    private Data getProposition(@PathVariable("proposition_id") int proposition_id) {
        Data data = new Data();
        try {
            Proposition prop = new Proposition();
            prop.setIdProposition(proposition_id);
            data.setData(prop.find());
        } catch (Exception e) {
            data.setError(e);
        }
        return data;
    }

    // creating a delete mapping that deletes a specified marque
    @DeleteMapping("/proposition/{proposition_id}")
    private void deleteBook(@PathVariable("proposition_id") int proposition_id) {
        Proposition prop = new Proposition();
        prop.setIdProposition(proposition_id);
        try {
            prop.deleteBase();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // creating post mapping that post the marque detail in the database
    @PostMapping("/Proposition")
    private int saveProposition(@RequestParam float valeur,@RequestParam String date,@RequestParam int idClient,@RequestParam int idEnchere) {

        try {
            Proposition prop=new Proposition();
            prop.setValeur(valeur);
            prop.setDateProposition(java.sql.Date.valueOf(date));
            prop.setIdClient(idClient);
            prop.setIdEnchere(idEnchere);
            prop.insertBase();
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }


    // creating put mapping that updates the marque detail
    @PutMapping("/Proposition")
    private int updateProposition(@RequestParam int idProposition,@RequestParam float valeur,@RequestParam String date,@RequestParam int idClient,@RequestParam int idEnchere) {

        try {
            Proposition prop=new Proposition();
            prop.setIdProposition(idProposition);
            prop.setValeur(valeur);
            prop.setDateProposition(java.sql.Date.valueOf(date));
            prop.setIdClient(idClient);
            prop.setIdEnchere(idEnchere);
            prop.insertBase();
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

}
