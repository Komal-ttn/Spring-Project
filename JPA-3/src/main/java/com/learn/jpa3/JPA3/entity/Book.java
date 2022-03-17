package com.learn.jpa3.JPA3.entity;

import javax.persistence.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String bookName;

    @OneToOne(cascade = CascadeType.ALL) @JoinColumn(name = "auth_id")
    private Author author;

    //Getter and Setter methods

  /* @ManyToOne
    @JoinColumn(name="auth_id")*/
    // private Author author;

    @ManyToMany(mappedBy = "books")
    private Set<Author> authors;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }


    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    public void addAuthors(Author author) {
        if (author != null) {
            if (authors == null) {
                authors = new HashSet<>();
            }
            author.setBooks(Collections.singleton(this));
            authors.add(author);
        }
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", author=" + authors +
                '}';
    }
}
