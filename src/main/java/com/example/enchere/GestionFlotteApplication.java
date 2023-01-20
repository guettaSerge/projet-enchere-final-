package com.example.enchere;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.sql.*;

@SpringBootApplication
public class GestionFlotteApplication {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        SpringApplication.run(GestionFlotteApplication.class, args);
        /*
        String bla= generatetoken.GenerateToken.genererTokenINSERT INTO Marques(NomMarque) VALUES('Tesla');
INSERT INTO Marques(NomMarque) VALUES('Renault');
INSERT INTO Type(Type, IdMarque) VALUES('Serie X', 1);
INSERT INTO Type(Type, IdMarque) VALUES('Duster', 2);
INSERT INTO Vehicules(Matricule, IdType) VALUES('1850 WWT', 1);
INSERT INTO Vehicules(Matricule, IdType) VALUES('9672 TBG', 2);
INSERT INTO Kilometrages(IdVehicule, Date, DebutKm , FinKm) VALUES(1, '2022-11-15', 0.00, 125.00);
INSERT INTO Kilometrages(IdVehicule, Date, DebutKm , FinKm) VALUES(2, '2022-11-15', 10000.00, 10075.00);"test");
        System.out.println(bla);
        String ex="9bd7c501080bc07ce00add929ef0f72f08c5c01d";
        System.out.print(check_Token(ex,"test"));

        Class.forName("org.postgresql.Driver"); // PostGres
        Connection con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/flotte","administrateur","12345");
        PreparedStatement stmt = con.prepareStatement("select*from marques");
        ResultSet rs = stmt.executeQuery();
        while(rs.next()){
            System.out.println(rs.getString(1));
            System.out.println(rs.getString(2));
        }
        */

        /*
        VehiculesService vs = new VehiculesService();
        System.out.println(vs.toString());
        List<Vehicules> lv = vs.getAllVehicules();
        System.out.println(lv.get(0).getMatricule());
         */
    }

}
