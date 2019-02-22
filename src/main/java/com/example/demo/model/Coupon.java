package com.example.demo.model;

import lombok.Data;

import java.util.Random;

@Data
public class Coupon {

    private Long id;
    private Boolean valid = Boolean.TRUE;

    public Double getDiscount() {
        if (valid)
            return Discount.percentages[new Random().nextInt(3)];

        return 1.0;
    }
}
