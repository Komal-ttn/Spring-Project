package com.learn.security.SecurityJPA.microservice.repository;

import com.learn.security.SecurityJPA.microservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {

    User findByEmail(String email);

}
