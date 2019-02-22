package com.example.demo.controller;


import com.example.demo.repository.CouponRepository;
import com.example.demo.model.Coupon;
import com.example.demo.response.MyResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/coupon")
public class CouponController {

    @Autowired
    CouponRepository couponRepository;

    @GetMapping("/submit")
    public ResponseEntity<String> checkCoupon(@RequestParam("coupon_id") Long couponId,
                              @RequestParam("price") Double price) {
        Coupon coupon = couponRepository.findById(couponId);
        if (coupon != null) {
            Double newPrice = price * coupon.getDiscount();
            coupon.setValid(Boolean.FALSE);
            couponRepository.update(coupon);
            return new ResponseEntity<String>(MyResponse.Success, HttpStatus.OK);
        }
        return new ResponseEntity<>(MyResponse.Failed, HttpStatus.OK);
    }

}
