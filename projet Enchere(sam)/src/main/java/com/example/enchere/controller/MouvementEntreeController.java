/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.enchere.controller;

import com.example.enchere.dao.Attribute;
import org.springframework.web.bind.annotation.*;

import com.example.enchere.model.Data;
import com.example.enchere.model.MouvementEntree;

import java.sql.Date;

/**
 *
 * @author pc
 */
@CrossOrigin(origins="*",allowedHeaders="*")
@RestController
@RequestMapping("/venteenchere")
public class MouvementEntreeController {


    // creating a get mapping that retrieves all the Marques detail from the
    // database
    @GetMapping("/mouvementEntree")
    private Data getAllMouvementEntree() {
        Data data = new Data();
        try {
            MouvementEntree mvt=new MouvementEntree();
            data.setData(mvt.find());
        } catch (Exception e) {
            data.setError(e);
        }
        return data;
    }

    // creating a get mapping that retrieves the detail of a specific marque
    @GetMapping("/mouvementEntree/{mouvementEntree_id}")
    private Data getMouvementEntree(@PathVariable("mouvementEntree_id") int mouvementEntree_id) {
        Data data = new Data();
        try {
            MouvementEntree mvt=new MouvementEntree() ;
            mvt.setIdMouvementEntree(mouvementEntree_id);
            data.setData(mvt.find());
        } catch (Exception e) {
            data.setError(e);
        }
        return data;
    }

    // creating a delete mapping that deletes a specified marque
    @DeleteMapping("/mouvementEntree/{mouvementEntree_id}")
    private void deleteBook(@PathVariable("mouvementEntree_id") int mouvementEntree_id) {
        MouvementEntree mvt=new MouvementEntree() ;
        mvt.setIdMouvementEntree(mouvementEntree_id);
        try {
            mvt.deleteBase();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // creating post mapping that post the marque detail in the database
    @PostMapping("/MouvementEntree")
    private int saveMouvementEntree(@RequestParam float valeur,@RequestParam String date,@RequestParam int idClient) {

        try {
            MouvementEntree mvt=new MouvementEntree();
            mvt.setValeur(valeur);
            mvt.setDate(Date.valueOf(date));
            mvt.setIdClient(idClient);
            mvt.insertBase();
            return 1;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // creating put mapping that updates the marque detail
    @PutMapping("/MouvementEntree")
    private int updateMouvementEntree(@RequestParam int idMouvementEntree,@RequestParam float valeur,@RequestParam String date,@RequestParam int idClient) {

        try {
            MouvementEntree mvt=new MouvementEntree();
            mvt.setIdMouvementEntree(idMouvementEntree);
            mvt.setValeur(valeur);
            mvt.setDate(Date.valueOf(date));
            mvt.setIdClient(idClient);
            mvt.updateBase();
            return 1;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
