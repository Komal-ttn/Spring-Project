package com.learn.jpa3.JPA3.extraQuestion.associations.onetomany.repository;

import com.learn.jpa3.JPA3.extraQuestion.associations.onetomany.entities.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer,Integer> {
}
