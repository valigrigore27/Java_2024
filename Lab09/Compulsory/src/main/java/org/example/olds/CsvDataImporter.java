package org.example.olds;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class CsvDataImporter {

    private String csvFile;
    private String cvsSplitBy;
    private int linesToRead;
    private BookDAO bookDAO;
    private AutorDAO autorDAO;

    public CsvDataImporter(String csvFile, String cvsSplitBy, int linesToRead, BookDAO bookDAO, AutorDAO autorDAO) {
        this.csvFile = csvFile;
        this.cvsSplitBy = cvsSplitBy;
        this.linesToRead = linesToRead;
        this.bookDAO = bookDAO;
        this.autorDAO = autorDAO;
    }

    public void importData() {
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            br.readLine();

            String line;
            while ((line = br.readLine()) != null && linesToRead-- > 0) {
                String[] data = line.split(cvsSplitBy);
                importBook(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void importBook(String[] data) {
        String title = data[1];
        String[] authors = data[2].split("/");
        String language = data[6];
        int numPages = Integer.parseInt(data[7]);
        String publicationDate = "20.03.2010";

        Arrays.stream(authors).map(String::trim).forEach(autorDAO::addAutor);

        Autor autor = new Autor(authors[0].trim());
        Book book = new Book(autor, publicationDate, language, numPages, title);
        bookDAO.addBook(book);

        System.out.println("Cartea '" + title + "' a fost adăugată în baza de date.");
    }
}
