package com.example.finalprojectrealestateapplication.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {
    @Autowired
    private com.example.finalprojectrealestateapplication.Repository.BookingRepository BookingRepository;
}
