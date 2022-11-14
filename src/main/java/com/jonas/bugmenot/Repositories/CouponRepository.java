package com.jonas.bugmenot.Repositories;

import com.jonas.bugmenot.Models.Coupon;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CouponRepository extends CrudRepository<Coupon, Long> {

    @Override
    Optional<Coupon> findById(Long id);
}
