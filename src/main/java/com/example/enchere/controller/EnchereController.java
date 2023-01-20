/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.enchere.controller;

import com.example.enchere.dao.Useful;
import com.example.enchere.model.*;
import com.example.enchere.modelAff.Encheres;
import org.springframework.web.bind.annotation.*;
import java.sql.Date;

/**
 *
 * @author pc
 */
@CrossOrigin(origins="*",allowedHeaders="*")
@RestController
@RequestMapping("/venteenchere")
public class EnchereController {
    


    // creating a get mapping that retrieves all the Marques detail from the
    // database
    @GetMapping("/enchere")
    private Data getAllEnchere() {
            Data data = new Data();
            try {

               Enchere ad =new Enchere();
                data.setData(ad.find());
            } catch (Exception e) {
                data.setError(e);
            }
            return data;
    }

    // creating a get mapping that retrieves the detail of a specific marque
    @GetMapping("/enchere/{idEnchere}")
    private Data getEnchere(@PathVariable("idEnchere") int idEnchere) {
        Data data = new Data();
        try {

            Enchere ad =new Enchere();
            ad.setIdEnchere(idEnchere);
            data.setData(ad.find());
        } catch (Exception e) {
            data.setError(e);
        }
        return data;
    }
    @GetMapping("/enchere/statut/{statut}")
    private Data getEnchereWithStatut(@PathVariable("statut") int statut) {
        Data data = new Data();
        try {

            Encheres ad =new Encheres();
            ad.setStatut(statut);
            data.setData(ad.find());
        } catch (Exception e) {
            data.setError(e);
        }
        return data;
    }


    // creating a delete mapping that deletes a specified marque
    @DeleteMapping("/enchere/{enchere_id}")
    private void deleteBook(@PathVariable("enchere_id") int client_id) {
        Enchere ad;
        ad = new Enchere();
        ad.setIdEnchere(client_id);
        try {
            ad.deleteBase();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // creating post mapping that post the marque detail in the database
    @PostMapping("/Enchere")
    private int saveEnchere(@RequestParam int idEnchere,@RequestParam int idProduit,@RequestParam int idClient, @RequestParam String debut, @RequestParam String duree,@RequestParam float prixDepart) {

        try {
           Enchere e=new Enchere();
           e.setIdEnchere(idEnchere);
           e.setIdClient(idClient);
           e.setDebut(Date.valueOf(debut));
           e.setFin(Useful.setStringToTime(duree));
           e.setPrixDepart(prixDepart);
           e.setIdProduit(idProduit);
            e.insertBase();
            return 1;
        }
        catch (Exception e){
            return 0;
        }
    }

    // creating put mapping that updates the marque detail
    @PutMapping("/Enchere")
    private int updateEnchere(@RequestParam int idProduit,@RequestParam int idClient, @RequestParam String debut, @RequestParam String duree,@RequestParam float prixDepart) {

        try {
            Enchere e=new Enchere();
            e.setIdClient(idClient);
            e.setDebut(Date.valueOf(debut));
            e.setFin(Useful.setStringToTime(duree));
            e.setPrixDepart(prixDepart);
            e.setIdProduit(idProduit);
            e.updateBase();
            return 1;
        }
        catch (Exception e){
            return 0;
        }
    }

}
