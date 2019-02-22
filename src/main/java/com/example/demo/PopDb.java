package com.example.demo;

import com.example.demo.model.Coupon;
import com.example.demo.model.Ticket;
import com.example.demo.repository.CouponRepository;
import com.example.demo.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.stream.IntStream;

@Component
public class PopDb implements CommandLineRunner {

    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    CouponRepository couponRepository;

    @Override
    public void run(String... strings) throws Exception {
        IntStream.range(1, 100).forEach(i -> {
            Ticket ticket = new Ticket();
            ticketRepository.insert(ticket);
        });

        IntStream.range(1,50).forEach(i -> {
            Coupon coupon = new Coupon();
            couponRepository.insert(coupon);
        });

    }
}
