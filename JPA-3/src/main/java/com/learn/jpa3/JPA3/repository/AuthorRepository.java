package com.learn.jpa3.JPA3.repository;

import com.learn.jpa3.JPA3.entity.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author,Integer> {
}
