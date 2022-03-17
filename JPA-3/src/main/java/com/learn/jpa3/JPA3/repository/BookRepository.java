package com.learn.jpa3.JPA3.repository;

import com.learn.jpa3.JPA3.entity.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Integer> {

}
