package com.example.kord.connexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion {
    static final String user = "root";
    static final String password = "123456";
    static final String url = "jdbc:mysql://localhost:3306/kordi_mobil";
    private static Connection con = null;
    static {

        try {
            Class.forName("com.mysql.jdbc.Driver");

            con = DriverManager.getConnection(url, user, password);

        } catch (ClassNotFoundException e1) {
            // TODO Auto-generated catch block
            System.out.println("Erreur du chargement du pilote");

            e1.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("Erreur de connecxion");
            e.printStackTrace();
        }
    }
    public static Connection getCon() {
        return con;
    }

}
