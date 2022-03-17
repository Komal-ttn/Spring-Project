package com.learn.jpa3.JPA3.extraQuestion.associations.manytomany.repository;

import com.learn.jpa3.JPA3.extraQuestion.associations.manytomany.entity.Programmer;
import org.springframework.data.repository.CrudRepository;

public interface ProgrammerRepository extends CrudRepository<Programmer,Integer> {
}
