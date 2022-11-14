package com.jonas.bugmenot.Services;

import com.jonas.bugmenot.Models.CouponModel;
import com.jonas.bugmenot.Repositories.CouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CouponService {

    @Autowired
    CouponRepository couponRepository;

    public void addCoupon(CouponModel coupon) {
        couponRepository.save(coupon);
    }
}
