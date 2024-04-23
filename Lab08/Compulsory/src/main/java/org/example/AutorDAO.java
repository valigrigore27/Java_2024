package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AutorDAO {
    private Connection connection;

    public AutorDAO() {
        try {
            connection = DatabaseConnection.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Autor> getAllAuthors() {
        List<Autor> authors = new ArrayList<>();
        String query = "SELECT * FROM autori";
        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("autor_id");
                String nume = resultSet.getString("nume");
                Autor autor = new Autor(id, nume);
                authors.add(autor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return authors;
    }
    public void deleteAutors() {
        String query = "DELETE FROM autori";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            int rowsAffected = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void addAutor(String nume) {
        String query = "INSERT INTO autori (nume) VALUES (?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, nume);
            statement.executeUpdate();
            System.out.println("Autorul a fost adăugat cu succes.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteDuplicate() {
        String query = "DELETE FROM autori WHERE autor_id NOT IN (SELECT MIN(autor_id) FROM autori GROUP BY nume)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            int rowsAffected = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
