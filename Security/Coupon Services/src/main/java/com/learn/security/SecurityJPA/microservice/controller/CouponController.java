package com.learn.security.SecurityJPA.microservice.controller;

import com.learn.security.SecurityJPA.microservice.entity.Coupon;
import com.learn.security.SecurityJPA.microservice.repository.CouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CouponController {

    @Autowired
    CouponRepository repo;


    @GetMapping("/showCreateCoupon")
    public String showCreateCoupon(){
        return "createCoupon";
    }

    @PostMapping("/saveCoupon")
    public String save(Coupon coupon) {
        repo.save(coupon);
        return "createResponse";
    }

    @GetMapping("/showGetCoupon")
    public String showGetCoupon() {
        return "getCoupon";
    }

    @PostMapping("/getCoupon")
    public ModelAndView getCoupon(String code) {
        ModelAndView mav = new ModelAndView("couponDetails");
        mav.addObject(repo.findByCode(code));
        return mav;
    }


}
