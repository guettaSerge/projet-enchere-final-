/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.enchere.controller;

import com.example.enchere.model.Admin;
import org.springframework.web.bind.annotation.*;

import com.example.enchere.model.Category;
import com.example.enchere.model.Data;


/**
 *
 * @author pc
 */
@CrossOrigin(origins="*",allowedHeaders="*")
@RestController
@RequestMapping("/venteenchere")
public class CategoryController {

    // creating a get mapping that retrieves all the Marques detail from the
    // database
    @GetMapping("/category")
    private Data getAllCategory() {
        Data data = new Data();
        try {

            Category ad =new Category();
            data.setData(ad.find());
        } catch (Exception e) {
            data.setError(e);
        }
        return data;
    }

    // creating a get mapping that retrieves the detail of a specific marque
    @GetMapping("/category/{category_id}")
    private Data getCategory(@PathVariable("category_id") int category_id) {
        Data data = new Data();
        try {

            Category ad =new Category();
            ad.setIdCategory(category_id);
            data.setData(ad.find());
        } catch (Exception e) {
            data.setError(e);
        }
        return data;
    }


    // creating a delete mapping that deletes a specified marque
    @DeleteMapping("/category/{category_id}")
    private void deleteBook(@PathVariable("category_id") int category_id) {

        Category ad =new Category();
        ad.setIdCategory(category_id);
        try {
            ad.deleteBase();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    // creating post mapping that post the marque detail in the database
    @PostMapping("/Category")
    private int saveCategory(@RequestParam int idCategory, @RequestParam String nom) {

        try {
           Category a = new Category();
            a.setIdCategory(idCategory);
            a.setNom(nom);
            a.insertBase();
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }
    // creating put mapping that updates the marque detail
    @PutMapping("/Category")
    private int updateCategory(@RequestParam int idCategory, @RequestParam String nom) {

        try {
            Category a = new Category();
            a.setIdCategory(idCategory);
            a.setNom(nom);
            a.updateBase();
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

}
