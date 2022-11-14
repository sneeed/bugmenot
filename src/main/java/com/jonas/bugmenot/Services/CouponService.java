package com.jonas.bugmenot.Services;

import com.jonas.bugmenot.Models.Coupon;
import com.jonas.bugmenot.Repositories.CouponRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CouponService {

    final CouponRepository couponRepository;

    public CouponService(CouponRepository couponRepository) {
        this.couponRepository = couponRepository;
    }

    public List<Coupon> getAllCoupons() {
        return (List<Coupon>) couponRepository.findAll();
    }

    public void createCoupon(Coupon coupon) {
        couponRepository.save(coupon);
    }

    public Optional<Coupon> getCouponById(long id) {
        return couponRepository.findById(id);
    }

    public Coupon updateCoupon(long id, Coupon updatedCoupon) {
        if (getCouponById(id).isPresent()) {
            Coupon existingCoupon = getCouponById(id).get();

            existingCoupon.setBenefit(updatedCoupon.getBenefit());
            existingCoupon.setUrl(updatedCoupon.getUrl());
            existingCoupon.setShop(updatedCoupon.getShop());
            existingCoupon.setDealProperty(updatedCoupon.getDealProperty());
            existingCoupon.setValidUntil(updatedCoupon.getValidUntil());
            existingCoupon.setConditionNewAndExistingCustomers(updatedCoupon.getConditionNewAndExistingCustomers());
            existingCoupon.setCountEncashments(updatedCoupon.getCountEncashments());
            existingCoupon.setConditionNoMinimumOrderValue(updatedCoupon.getConditionNoMinimumOrderValue());

            return couponRepository.save(updatedCoupon);
        }
        return null;
    }

    public Optional<Coupon> deleteCoupon(long id) {
        Optional<Coupon> coupon = couponRepository.findById(id);
        coupon.ifPresent(couponRepository::delete);
        return coupon;
    }
}
