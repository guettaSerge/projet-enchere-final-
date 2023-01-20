package com.example.enchere.controller;
import com.example.enchere.dao.Attribute;
import com.example.enchere.model.Statistiques;
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
public class StatistiqueController {


    // creating a get mapping that retrieves all the Marques detail from the
    // database
    @GetMapping("/Statistiques")
    private Data getAllAdmin() {
        Data data = new Data();
        try {
            Statistiques ad =new Statistiques();
            ad.find();
            data.setData(ad);
        } catch (Exception e) {
            data.setError(e);
        }
        return data;
    }

    // creating a get mapping that retrieves the detail of a specific marque
    @GetMapping("/statistiques/{month}/{year}")
    private Data getAdmin(@PathVariable("admin_id") int month,@PathVariable("admin_id") int years) {
        Data data = new Data();
        try {
            Statistiques ad =new Statistiques();
            ad.setMonth(month);
            ad.setYears(years);
            ad.find();
            data.setData(ad);
        } catch (Exception e) {
            data.setError(e);
        }
        return data;
    }

}
