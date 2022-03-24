package com.example.jpql.JPAAdvance.inheritance.repository;

import com.example.jpql.JPAAdvance.inheritance.entity.Payment;
import org.springframework.data.repository.CrudRepository;

public interface PaymentRepository extends CrudRepository<Payment,Integer> {


}
