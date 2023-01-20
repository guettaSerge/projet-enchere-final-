/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.enchere.controller;

import com.example.enchere.dao.Attribute;
import org.springframework.web.bind.annotation.*;

import com.example.enchere.model.Admin;
import com.example.enchere.model.Data;

/**
 *
 * @author pc
 */
@CrossOrigin(origins="*",allowedHeaders="*")
@RestController
@RequestMapping("/venteenchere")
public class AdminController {
    

    // creating a get mapping that retrieves all the Marques detail from the
    // database
    @GetMapping("/admin")
    private Data getAllAdmin() {
        Data data = new Data();
        try {

            Admin ad =new Admin();
            data.setData(ad.find());
        } catch (Exception e) {
            data.setError(e);
        }
        return data;
    }

    // creating a get mapping that retrieves the detail of a specific marque
    @GetMapping("/admin/{admin_id}")
    private Data getAdmin(@PathVariable("admin_id") int admin_id) {
        Data data = new Data();
        try {
            Admin ad =new Admin();
            ad.setIdAdmin(admin_id);
            data.setData(ad.find());
        } catch (Exception e) {
            data.setError(e);
        }
        return data;
    }

    // creating a delete mapping that deletes a specified marque
    @DeleteMapping("/admin/{admin_id}")
    private void deleteBook(@PathVariable("admin_id") int admin_id) {
        Admin ad =new Admin();
        ad.setIdAdmin(admin_id);
        try {
            ad.deleteBase();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // creating post mapping that post the marque detail in the database
    @PostMapping("/Admin")
    private int saveAdmin(@RequestParam int idAdmin,@RequestParam String nom,@RequestParam String email,@RequestParam String passe) {

      try {
          Admin a=new Admin();
          a.setIdAdmin(idAdmin);
          a.setNom(nom);
          a.setEmail(email);
          a.setPasse(passe);
          a.insertBase();
          return 1;
      }
      catch (Exception e){
          return 0;
      }


    }

    // creating put mapping that updates the marque detail
    @PutMapping("/Admin")
    private int updateAdmin(@RequestParam int client_id,@RequestParam String nom,@RequestParam String email,@RequestParam String passe) {

        try {
            Admin a=new Admin();
            a.setIdAdmin(client_id);
            a.setNom(nom);
            a.setEmail(email);
            a.setPasse(passe);
            a.updateBase();
            return 1;
        }
        catch (Exception e){
            return 0;
        }


    }

}
