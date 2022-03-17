package com.learn.jpa3.JPA3;

import com.learn.jpa3.JPA3.entity.Address;
import com.learn.jpa3.JPA3.entity.Author;
import com.learn.jpa3.JPA3.entity.Book;
//import com.learn.jpa3.JPA3.entity.Subject;
import com.learn.jpa3.JPA3.repository.AuthorRepository;
import com.learn.jpa3.JPA3.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootTest
public class Testing {

    @Autowired
    BookRepository repository;

    @Autowired
    AuthorRepository authorRepository;

    //ONE TO ONE
    @Test
    public void testCreate() {
        Author author = new Author();
        Book book=new Book();
        Address address = new Address();

        address.setStreetNumber(74);
        address.setLocation("Rohini");
        address.setState("Delhi");

        author.setAuthName("Shrey");
        author.setAddress(address);

        List<String> subjects = new ArrayList<>();

        subjects.add("English");
        subjects.add("Hindi");
        subjects.add("DBMS");


        author.setSubjects(subjects);
        book.setBookName("STUDY IS KEY");
        book.setAuthor(author);

        repository.save(book);
    }
    //one to one

    @Test
    public void testOTOCreate() {
        Author author = new Author();
        Book book = new Book();

        List<String> subjects = new ArrayList<>();

        subjects.add("English");
        subjects.add("Hindi");
        subjects.add("DBMS");

        author.setSubjects(subjects);

        Address address = new Address();

        address.setStreetNumber(74);
        address.setLocation("Rohini");
        address.setState("Delhi");

        author.setAuthName("Riya");
        author.setAddress(address);
        book.setBookName("INTRO TO JPA");
        book.setAuthor(author);

        repository.save(book);
    }

    //one to many

    @Test
    public void testOTMcreate(){
        Author author=new Author();
        Address address=new Address();
        HashSet<Book> books = new HashSet<>();


        address.setStreetNumber(14);
        address.setLocation("Noida");
        address.setState("UP");

        List<String> subjects=new ArrayList<>();

        subjects.add("JAVA");
        subjects.add("C++");
        subjects.add("Python");

        author.setSubjects(subjects);

        author.setAuthName("Shiii");
        author.setAddress(address);

        Book book1=new Book();
        Book book2=new Book();
        Book book3=new Book();

        book1.setBookName("Hibernate");
        books.add(book1);
        book2.setBookName("Spring Security");
        books.add(book2);
        book3.setBookName("Rest Api");
        books.add(book3);

        author.setBooks(books);

        authorRepository.save(author);

    }

    //One to Many BiDirectional

    @Test
    public void testOTMBCreate(){

        Author author=new Author();
        Address address=new Address();

        address.setStreetNumber(14);
        address.setLocation("Noida");
        address.setState("UP");

        List<String> subjects=new ArrayList<>();

        subjects.add("JAVA");
        subjects.add("C++");
        subjects.add("Python");

        author.setSubjects(subjects);
        author.setAuthName("Sofiaa");
        author.setAddress(address);

        Book book1=new Book();
        Book book2=new Book();

        book1.setBookName("Database made easy");
        book2.setBookName("Java is Fun");

        author.addBooks(book1);
        author.addBooks(book2);

        authorRepository.save(author);
    }

    //Many to Many

    @Test
    @Rollback(value = true)
    public void testMTMCreate(){

        Author author1=new Author();
        Address address1=new Address();

        Set<Author> authors=new HashSet<Author>();
        Set<Book> books=new HashSet<Book>();
        Set<Book> books2=new HashSet<Book>();

        address1.setStreetNumber(14);
        address1.setLocation("Noida");
        address1.setState("UP");

        List<String> subjects1=new ArrayList<>();

        subjects1.add("JAVA");
        subjects1.add("C++");
        subjects1.add("Python");

        author1.setSubjects(subjects1);
        author1.setAuthName("Sofiaa");
        author1.setAddress(address1);

        Author author2=new Author();
        Address address2=new Address();

        address2.setStreetNumber(10);
        address2.setLocation("Faridabad");
        address2.setState("Haryana");

        List<String> subjects2=new ArrayList<>();

        subjects2.add("Math");
        subjects2.add("Software Eng");
        subjects2.add("Linux");

        author2.setSubjects(subjects2);
        author2.setAuthName("Royaaa");
        author2.setAddress(address2);

        authors.add(author1);
        authors.add(author2);

        Book book1=new Book();
        Book book2=new Book();

        book1.setBookName("Database ii");
        book2.setBookName("Java FUn");

        Book book3=new Book();
        Book book4=new Book();

        book3.setBookName("Millionare");
        book4.setBookName("Never");

        books.add(book1);
        books.add(book2);
        books.add(book3);
        books2.add(book4);
        books2.add(book3);

        author1.setBooks(books);
        author2.setBooks(books2);


        List<Author> authorList = new ArrayList<>();
        authorList.add(author1);
        authorList.add(author2);
        authorRepository.saveAll(authorList);

    }
}
