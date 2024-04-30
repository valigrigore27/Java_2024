package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
    private Connection connection;

    public BookDAO() {
        try {
            connection = DatabaseConnectionPool.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();
        String query = "SELECT * FROM carti";
        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("carte_id");
                String title = resultSet.getString("titlu");
                String language = resultSet.getString("limba");
                String dataPublicarii = resultSet.getString("data_publicarii");
                int pagesNumber = resultSet.getInt("numar_pagini");
                int autorId = resultSet.getInt("autor_id");

                String autorQuery = "SELECT nume FROM autori WHERE autor_id = ?";
                try (PreparedStatement autorStatement = connection.prepareStatement(autorQuery)) {
                    autorStatement.setInt(1, autorId);
                    try (ResultSet autorResultSet = autorStatement.executeQuery()) {
                        if (autorResultSet.next()) {
                            String autorName = autorResultSet.getString("nume");

                            Autor autor = new Autor(autorId, autorName);
                            Book book = new Book(autor, dataPublicarii, id, language ,pagesNumber, title);
                            books.add(book);
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    public void deleteAllBooks() {
        String query = "DELETE FROM carti";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            int rowsAffected = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addBook(Book book) {
        int autorId = getAuthorIdByName(book.getAutor().getNume());
        if (autorId == -1) {
            System.out.println("Eroare: Autorul " + book.getAutor().getNume() + " nu a fost găsit în baza de date.");
            return;
        }

        String query = "INSERT INTO carti (titlu, limba, data_publicarii, numar_pagini, autor_id) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, book.getTitle());
            statement.setString(2, book.getLanguage());
            statement.setString(3, book.getDate());
            statement.setInt(4, book.getPagesNumber());
            statement.setInt(5, autorId);

            statement.executeUpdate();
            System.out.println("Cartea a fost adăugată cu succes!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getAuthorIdByName(String authorName) {
        String query = "SELECT autor_id FROM autori WHERE nume = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, authorName);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt("autor_id");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // Returnăm -1 în caz de eroare sau dacă autorul nu a fost găsit
        return -1;
    }

    public void deleteDuplicates() {
        String query = "DELETE FROM carti WHERE carte_id NOT IN (SELECT MIN(carte_id) FROM carti GROUP BY titlu)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            int rowsAffected = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
