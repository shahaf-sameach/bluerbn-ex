package com.example.demo.controller;


import com.example.demo.cache.CacheService;
import com.example.demo.repository.TicketRepository;
import com.example.demo.response.MyResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    private TicketRepository ticketRepository;

    private CacheService cacheService;

    @PostConstruct
    public void init() {
        this.cacheService = new CacheService(ticketRepository);
    }

    @GetMapping("/availability")
    public ResponseEntity<String> checkAvaiblity(@RequestParam("ticket_id") Long ticketId) {
        if (cacheService.get(ticketId) != null)
            return new ResponseEntity<>(MyResponse.Success, HttpStatus.OK);

        return new ResponseEntity<>(MyResponse.Failed, HttpStatus.OK);
    }

}
