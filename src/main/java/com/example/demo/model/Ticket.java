package com.example.demo.model;

import lombok.Data;

@Data
public class Ticket {

    private Long id;
    private String name;
    private Long source;
    private Long destination;
    private Boolean checkedIn = Boolean.FALSE;
}
