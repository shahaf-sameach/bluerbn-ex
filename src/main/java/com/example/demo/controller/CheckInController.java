package com.example.demo.controller;


import com.example.demo.response.MyResponse;
import com.example.demo.service.CheckInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ticket")
public class CheckInController {

    @Autowired
    CheckInService checkInService;

    @GetMapping("/checkIn")
    public ResponseEntity<String> checkIn(@RequestParam("destination_id") Long destinationId,
                          @RequestParam("baggage_id") String baggageId) {
        if (checkInService.isValid(destinationId, baggageId)) {
            return new ResponseEntity<>(MyResponse.Success, HttpStatus.OK);
        }
        return new ResponseEntity<>(MyResponse.Failed, HttpStatus.OK);
    }

}
