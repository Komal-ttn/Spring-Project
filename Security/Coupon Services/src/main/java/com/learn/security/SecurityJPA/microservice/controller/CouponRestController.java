package com.learn.security.SecurityJPA.microservice.controller;

import com.learn.security.SecurityJPA.microservice.entity.Coupon;
import com.learn.security.SecurityJPA.microservice.repository.CouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/couponapi")
public class CouponRestController {

    @Autowired
    CouponRepository repository;

    @GetMapping("/hello")
    public String hello(){
        return "Spring Security";
    }


    @PostMapping(value = "/coupons")
    public Coupon create(@RequestBody Coupon coupon){


        return repository.save(coupon);
    }

    @GetMapping(value ="/coupons/{code}")
    public Coupon getCoupon(@PathVariable("code") String code){

        return repository.findByCode(code);

    }




}
