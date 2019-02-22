package com.example.demo.repository;

import com.example.demo.model.Ticket;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class TicketRepository implements SimpleRepo{

    private AtomicLong index = new AtomicLong(0);
    private Map<Long, Ticket> tickets = new HashMap<>();

    public Ticket findById(Long id){
        return tickets.getOrDefault(id, null);
    }

    public void insert(Ticket ticket) {
        ticket.setId(index.incrementAndGet());
        tickets.put(ticket.getId(), ticket);
    }

}
