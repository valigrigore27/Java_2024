package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            conn = DatabaseConnectionPool.getConnection();
            System.out.println("Conexiunea la baza de date a fost stabilita.");

              //AutorDAO autorDAO = new AutorDAO();
//            autorDAO.addAutor("Ion Creanga");
//            autorDAO.addAutor("Mihail Sadoveanu");
//            autorDAO.addAutor("Agatha Christie");
//            autorDAO.addAutor("Vali");
//            autorDAO.deleteAutors();
//            autorDAO.deleteDuplicate();

//
//            List<Autor> autori = autorDAO.getAllAuthors();
//            for (Autor autor : autori) {
//                System.out.println("ID: " + autor.getId() + ", Nume: " + autor.getNume());
//            }



            //BookDAO bookDAO = new BookDAO();
//            String name = "Ion Creanga";
//            Autor autor1 = new Autor(name);
//            //Book book1 = new Book(autor1, "31.10.2020","romana", 200, "The title");
//            Book book1 = new Book(autor1, "20.2.1880","romana", 30, "Un exemplu");
//            bookDAO.addBook(book1);
            //bookDAO.deleteAllBooks();


//            List<Book> books = bookDAO.getAllBooks();
//            for (Book book : books) {
//                System.out.println(book.toString());
//            }

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



            String csvFile = "C://Users//Tuf//OneDrive//Desktop//Programare-Avansata-2024//Lab08//Homework//books.csv";
            String cvsSplitBy = ",";
            int linesToRead = 20;

            BookDAO bookDAO = new BookDAO();
            AutorDAO autorDAO = new AutorDAO();

            //bookDAO.deleteAllBooks();
            //autorDAO.deleteAutors();
//            CsvDataImporter csvDataImporter = new CsvDataImporter(csvFile, cvsSplitBy, linesToRead, bookDAO, autorDAO);
//            csvDataImporter.importData();
            autorDAO.deleteDuplicate();
            bookDAO.deleteDuplicates();










        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            if (conn != null) {
                DatabaseConnectionPool.closeConnection(conn);
                System.out.println("Conexiunea la baza de date a fost inchisa.");
            }
        }
    }
}
