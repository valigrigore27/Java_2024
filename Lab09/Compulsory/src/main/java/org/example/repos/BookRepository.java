package org.example.repos;

import org.example.models.Book;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class BookRepository {

    private final EntityManager entityManager;

    public BookRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void create(Book book) {
        entityManager.getTransaction().begin();
        entityManager.persist(book);
        entityManager.getTransaction().commit();
    }

    public Book findById(int id) {
        return entityManager.find(Book.class, id);
    }

    public List<Book> findByName(String name) {
        Query query = entityManager.createQuery("SELECT b FROM Book b WHERE b.title = :name");
        query.setParameter("name", name);
        return query.getResultList();
    }
    public void deleteByName(String name) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("DELETE FROM Book b WHERE b.title = :name");
        query.setParameter("name", name);
        query.executeUpdate();
        entityManager.getTransaction().commit();
    }

}
