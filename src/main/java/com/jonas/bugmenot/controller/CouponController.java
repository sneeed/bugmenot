package com.jonas.bugmenot.controller;

import com.jonas.bugmenot.Models.Coupon;
import com.jonas.bugmenot.Services.CouponService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("coupons")
public class CouponController {

    final CouponService couponService;

    public CouponController(CouponService couponService) {
        this.couponService = couponService;
    }

    @GetMapping
    public ResponseEntity<List<Coupon>> getAllCoupons() {
        List<Coupon> allCoupons = couponService.getAllCoupons();
        return new ResponseEntity<>(allCoupons, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Coupon> createCoupon(@RequestBody Coupon coupon) {
        couponService.createCoupon(coupon);
        return new ResponseEntity<>(coupon, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Coupon> updateCoupon(@PathVariable long id, @RequestBody Coupon updatedCoupon) {
        return new ResponseEntity<>(couponService.updateCoupon(id, updatedCoupon), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Coupon> getCouponById(@PathVariable long id) {
        Optional<Coupon> coupon = couponService.getCouponById(id);
        return new ResponseEntity<>(coupon.get(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Coupon> deleteCouponById(@PathVariable long id) {
        return new ResponseEntity<>(couponService.deleteCoupon(id).get(), HttpStatus.NO_CONTENT);
    }
}
