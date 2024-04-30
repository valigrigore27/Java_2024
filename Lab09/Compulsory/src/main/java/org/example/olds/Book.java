package org.example.olds;

public class Book {
    private int id;
    private String title;
    private String language;
    private String  date;
    private int pagesNumber;
    private Autor autor;

    public Book(Autor autor, String date, int id, String language, int pagesNumber, String title) {
        this.autor = autor;
        this.date = date;
        this.id = id;
        this.language = language;
        this.pagesNumber = pagesNumber;
        this.title = title;
    }
    public Book(Autor autor, String date, String language, int pagesNumber, String title) {
        this.autor = autor;
        this.date = date;
        this.language = language;
        this.pagesNumber = pagesNumber;
        this.title = title;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPagesNumber() {
        return pagesNumber;
    }

    public void setPagesNumber(int pagesNumber) {
        this.pagesNumber = pagesNumber;
    }

    @Override
    public String toString() {
        return "Book{" +
                "autor=" + autor.getNume() +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", language='" + language + '\'' +
                ", date='" + date + '\'' +
                ", pagesNumber=" + pagesNumber +
                '}';
    }
}
