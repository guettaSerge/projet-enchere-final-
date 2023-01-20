/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.enchere.controller;

import com.example.enchere.model.Admin;
import com.example.enchere.model.Client;
import com.example.enchere.modelAff.ClientSolde;
import org.springframework.web.bind.annotation.*;

import com.example.enchere.model.Data;


/**
 *
 * @author pc
 */
@CrossOrigin(origins="*",allowedHeaders="*")
@RestController
@RequestMapping("/Client")
public class ClientController {

    // creating a get mapping that retrieves all the Marques detail from the
    // database
    @GetMapping("/client")
    private Data getAllClient() {
        Data data = new Data();
        try {

            Client ad;
            ad = new Client();
            data.setData(ad.find());
        } catch (Exception e) {
            data.setError(e);
        }
        return data;
    }

    // creating a get mapping that retrieves the detail of a specific marque
    @GetMapping("/client/{client_id}")
    public Data getClient (@PathVariable("client_id")int client_id) throws Exception{
        Data data = new Data();
        try {

            Client ad;
            ad = new Client();
            ad.setIdClient(client_id);
            data.setData(ad.find());
        } catch (Exception e) {
            data.setError(e);
        }
        return data;
    }
    @GetMapping("/client/solde/{client_id}")
    public Data getClientSolde (@PathVariable("client_id")int client_id) throws Exception{
        Data data = new Data();
        try {

            ClientSolde ad;
            ad = new ClientSolde();
            ad.setIdClient(client_id);
            data.setData(ad.find());
        } catch (Exception e) {
            data.setError(e);
        }
        return data;
    }

    // creating a delete mapping that deletes a specified marque
    @DeleteMapping("/client/{client_id}")
    private void deleteBook(@PathVariable("client_id") int client_id) {
        Client ad;
        ad = new Client();
        ad.setIdClient(client_id);
        try {
            ad.deleteBase();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // creating post mapping that post the marque detail in the database
    @PostMapping("/Client")
    private int saveClient(@RequestParam int idAdmin,@RequestParam String nom,@RequestParam String email,@RequestParam String passe) {

        try {
            Client a=new Client();
            a.setIdClient(idAdmin);
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
    @PutMapping("/venteenchere")
    private int updateClient(@RequestParam int idAdmin,@RequestParam String nom,@RequestParam String email,@RequestParam String passe) {

            try {
                Client a=new Client();
                a.setIdClient(idAdmin);
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
}
