package org.example.repos;

import org.example.models.Author;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class AuthorRepository {

    private final EntityManager entityManager;

    public AuthorRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void create(Author author) {
        entityManager.getTransaction().begin();
        entityManager.persist(author);
        entityManager.getTransaction().commit();
    }

    public Author findById(int id) {
        return entityManager.find(Author.class, id);
    }

    public List<Author> findByName(String name) {
        Query query = entityManager.createQuery("SELECT a FROM Author a WHERE a.name = :name");
        query.setParameter("name", name);
        return query.getResultList();
    }

    public void deleteByName(String name) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("DELETE FROM Author a WHERE a.name = :name");
        query.setParameter("name", name);
        query.executeUpdate();
        entityManager.getTransaction().commit();
    }

}
