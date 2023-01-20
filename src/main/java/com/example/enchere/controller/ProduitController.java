/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.enchere.controller;

import org.springframework.web.bind.annotation.*;

import com.example.enchere.model.Data;
import com.example.enchere.model.Produit;

/**
 *
 * @author pc
 */
@CrossOrigin(origins="*",allowedHeaders="*")
@RestController
@RequestMapping("/venteenchere")
public class ProduitController {


    // creating a get mapping that retrieves all the Marques detail from the
    // database
    @GetMapping("/produit")
    private Data getAllProduit() {
        Data data = new Data();
        try {
            Produit prod=new Produit();
            data.setData(prod.find());
        } catch (Exception e) {
            data.setError(e);
        }
        return data;
    }

    // creating a get mapping that retrieves the detail of a specific marque
    @GetMapping("/produit/{produit_id}")
    private Data getProduit(@PathVariable("produit_id") int produit_id) {
        Data data = new Data();
        try {
            Produit prod=new Produit();
            prod.setIdProduit(produit_id);
            data.setData(prod.find());
        } catch (Exception e) {
            data.setError(e);
        }
        return data;
    }

    // creating a delete mapping that deletes a specified marque
    @DeleteMapping("/produit/{produit_id}")
    private void deleteBook(@PathVariable("produit_id") int produit_id) {

        Produit prod=new Produit();
        prod.setIdProduit(produit_id);
        try {
            prod.deleteBase();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // creating post mapping that post the marque detail in the database
    @PostMapping("/produit")
    private int saveProduit(@RequestParam String nom,@RequestParam int idCategory){
        Produit prod=new Produit();
        prod.setNom(nom);
        prod.setIdCategory(idCategory);
        try {
            prod.insertBase();
            return 1;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    // creating put mapping that updates the marque detail
    @PutMapping("/produit")
    private int updateProduit(@RequestParam int idProduit,@RequestParam String nom,@RequestParam int idCategory){
        Produit prod=new Produit();
        prod.setIdProduit(idProduit);
        prod.setNom(nom);
        prod.setIdCategory(idCategory);
        try {
            prod.updateBase();
            return 1;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
