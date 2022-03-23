package com.learn.security.SecurityJPA.microservice.repository;

import com.learn.security.SecurityJPA.microservice.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role,Integer> {
}
