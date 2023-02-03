/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.enchere.controller;

import com.example.enchere.dao.Useful;
import com.example.enchere.model.*;
import com.example.enchere.modelAff.Encheres;
import com.example.enchere.traitement.RechercheMultiParametre;
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
    @GetMapping("/encheres")
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
            RechercheMultiParametre parametre=new RechercheMultiParametre();
            parametre.setStatut(statut);
            data.setData(ad.multiCritere(parametre));
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
    private Data saveEnchere(@RequestParam String nom,@RequestParam String description,@RequestParam int idClient,@RequestParam int idCategory, @RequestParam String debut, @RequestParam String duree,@RequestParam float prixDepart) {
        Data data = new Data();
        try {
           Enchere e=new Enchere();
           e.setNom(nom);
           e.setIdClient(idClient);
           e.setDebut(Date.valueOf(debut));
           e.setDuree(duree);
           e.setPrixDepart(prixDepart);
           e.setIdCategory(idCategory);
           e.setDescriptions(description);
            e.insertionBase();
            data.setData(e);
        }
        catch (Exception e){
            data.setError(e);
        }
        return data;
    }

    // creating put mapping that updates the marque detail
    @PutMapping("")
    private Data updateEnchere(@RequestParam int idEnchere,@RequestParam String description,@RequestParam int idClient,@RequestParam int idCategory, @RequestParam String debut, @RequestParam String duree,@RequestParam float prixDepart) {
        Data data = new Data();
        try {
            Enchere e=new Enchere();
            e.setIdEnchere(idEnchere);
            e.setIdClient(idClient);
            e.setDebut(Date.valueOf(debut));
            e.setDuree(duree);
            e.setPrixDepart(prixDepart);
            e.setIdCategory(idCategory);
            e.setDescriptions(description);
            e.insertBase();
           data.setData(e);
        }
        catch (Exception e){
            data.setError(e);
        }
        finally {

        }
        return  data;
    }
    @GetMapping("/enchere/recherche")
    private Data rechercheMulticritere(@RequestParam String motclef,@RequestParam Date debut ,@RequestParam Date fin,@RequestParam double min, @RequestParam double max, @RequestParam int statut) {
        Data data = new Data();
        try {
            Date[] date={debut,fin};
            Double[] prix={min,max};
            RechercheMultiParametre parametre=new RechercheMultiParametre();
            parametre.setMotClef(motclef);
            parametre.setPrixObjet(prix);
            parametre.setIntervalle(date);
            parametre.setStatut(statut);
           data.setData(new Encheres().multiCritere(parametre));

        }
        catch (Exception e){
            data.setError(e);
        }
        return data;
    }

}
