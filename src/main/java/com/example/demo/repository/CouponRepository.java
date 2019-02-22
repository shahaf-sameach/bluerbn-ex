package com.example.demo.repository;

import com.example.demo.model.Coupon;
import com.example.demo.model.Ticket;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class CouponRepository implements SimpleRepo {

    private AtomicLong index = new AtomicLong(0);
    private Map<Long, Coupon> coupons = new HashMap<>();

    public Coupon findById(Long id){
        return coupons.getOrDefault(id, null);
    }

    public void insert(Coupon coupon) {
        coupon.setId(index.incrementAndGet());
        coupons.put(coupon.getId(), coupon);
    }

    public void update(Coupon coupon) {
        coupons.put(coupon.getId(), coupon);
    }
}
