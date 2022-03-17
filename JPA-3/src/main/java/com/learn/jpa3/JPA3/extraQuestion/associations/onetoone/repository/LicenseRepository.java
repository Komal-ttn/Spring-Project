package com.learn.jpa3.JPA3.extraQuestion.associations.onetoone.repository;

import com.learn.jpa3.JPA3.extraQuestion.associations.onetoone.entity.License;
import org.springframework.data.repository.CrudRepository;

public interface LicenseRepository extends CrudRepository<License,Integer> {
}
