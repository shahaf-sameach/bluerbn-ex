package com.example.demo.repository;

import com.example.demo.model.Ticket;

public interface SimpleRepo<T> {
    T findById(Long id);
}
