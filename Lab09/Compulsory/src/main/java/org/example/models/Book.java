package org.example.models;

import javax.persistence.*;

@Entity
@Table(name = "carti")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "carte_id")
    private int id;

    @Column(name = "titlu")
    private String title;

    @Column(name = "limba")
    private String language;

    @Column(name = "data_publicarii")
    private String publicationDate;

    @Column(name = "numar_pagini")
    private int numberOfPages;

    @ManyToOne
    @JoinColumn(name = "autor_id", nullable = false)
    private Author author;



    public Book() {
    }

    public Book(String title, String language, String publicationDate, int numberOfPages, Author author) {
        this.title = title;
        this.language = language;
        this.publicationDate = publicationDate;
        this.numberOfPages = numberOfPages;
        this.author = author;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", language='" + language + '\'' +
                ", publicationDate='" + publicationDate + '\'' +
                ", numberOfPages=" + numberOfPages +
                ", author=" + author +
                '}';
    }
}
