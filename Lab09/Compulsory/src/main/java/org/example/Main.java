package org.example;

import org.example.models.Author;
import org.example.models.Book;
import org.example.repos.AuthorRepository;
import org.example.repos.BookRepository;
import org.example.utils.EntityManagerFactorySingleton;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = EntityManagerFactorySingleton.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        BookRepository bookRepository = new BookRepository(entityManager);
        AuthorRepository authorRepository = new AuthorRepository(entityManager);

        try {
            Author author = new Author("Mihail Sadoveanu");
            authorRepository.create(author);

            Book book = new Book("Dumbrava minunata", "rom", "unknown", 200, author);
            bookRepository.create(book);

//            Book foundBook = bookRepository.findById(48);
//            System.out.println("Book found by ID: " + foundBook);
//
//            List<Author> authorsByName = authorRepository.findByName("Vali");
//            System.out.println("Authors found by name: " + authorsByName);
//
//            List<Book> booksByName = bookRepository.findByName("Notes from a Small Island");
//            System.out.println("Books found by name: " + booksByName);

        } finally {
            entityManager.close();
            EntityManagerFactorySingleton.closeEntityManagerFactory();
        }
    }
}
