package com.jonas.bugmenot.controller;

import com.jonas.bugmenot.Models.CouponModel;
import com.jonas.bugmenot.Services.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("coupon")
public class CouponController {

    @Autowired
    CouponService couponService;

    @PostMapping(value = "/add")
    public String addCoupon(@RequestBody CouponModel coupon) {
        couponService.addCoupon(coupon);
        return "home";
    }
}
