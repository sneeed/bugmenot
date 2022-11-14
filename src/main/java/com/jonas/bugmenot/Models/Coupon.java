package com.jonas.bugmenot.Models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name="coupon")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Coupon {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
//    TODO change some to enum later on
    String shop;
    String benefit;
    String dealProperty;
    Date validUntil;
    Boolean conditionNoMinimumOrderValue;
    Boolean conditionNewAndExistingCustomers;
    Integer countEncashments = 0;
    String url;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Coupon that = (Coupon) o;
        return id != 0 && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
