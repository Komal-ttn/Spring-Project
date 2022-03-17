package com.learn.jpa3.JPA3.entity;

import javax.persistence.*;
import java.util.*;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int authId;

    private String authName;

    @Embedded
    private Address address;

   @OneToOne(mappedBy = "author")
   private Book book;
    //@OneToMany(mappedBy = "author",cascade = CascadeType.ALL)

   @ManyToMany(cascade = CascadeType.ALL)
   @JoinTable(name = "authors_book",
           joinColumns = @JoinColumn(name="author_id",referencedColumnName = "authId"),
           inverseJoinColumns = @JoinColumn(name = "book_id",referencedColumnName = "id"))
    private Set<Book> books;

    @ElementCollection
    List<String> subjects = new ArrayList<String>();

    public int getAuthId() {
        return authId;
    }

    public void setAuthId(int authId) {
        this.authId = authId;
    }

    public String getAuthName() {
        return authName;
    }

    public void setAuthName(String authName) {
        this.authName = authName;
    }


    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }
/*
    For one to one
    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }*/


    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public void addBooks(Book book) {
        if (book != null) {
            if (books == null) {
                books = new HashSet<>();
            }
            book.setAuthor(this);
            books.add(book);
        }
    }
}
