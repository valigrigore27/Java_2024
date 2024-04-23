package org.example;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            conn = DatabaseConnection.getConnection();
            System.out.println("Conexiunea la baza de date a fost stabilita.");

            AutorDAO autorDAO = new AutorDAO();
//            autorDAO.addAutor("Ion Creanga");
//            autorDAO.addAutor("Mihail Sadoveanu");
//            autorDAO.addAutor("Agatha Christie");
            autorDAO.addAutor("Vali");

            //autorDAO.deleteAutors();
            //autorDAO.deleteDuplicate();

            List<Autor> autori = autorDAO.getAllAuthors();
            for (Autor autor : autori) {
                System.out.println("ID: " + autor.getId() + ", Nume: " + autor.getNume());
            }
        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                    System.out.println("Conexiunea la baza de date a fost inchisa.");
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}
