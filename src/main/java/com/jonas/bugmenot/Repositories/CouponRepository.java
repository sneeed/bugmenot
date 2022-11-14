package com.jonas.bugmenot.Repositories;

import com.jonas.bugmenot.Models.CouponModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CouponRepository extends CrudRepository<CouponModel, Long> {
}
