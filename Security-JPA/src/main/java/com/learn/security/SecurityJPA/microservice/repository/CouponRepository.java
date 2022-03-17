package com.learn.security.SecurityJPA.microservice.repository;


import com.learn.security.SecurityJPA.microservice.entity.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepository extends JpaRepository<Coupon,Integer> {


    Coupon findByCode(String code);
}
