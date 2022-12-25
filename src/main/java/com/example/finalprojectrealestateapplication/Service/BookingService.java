package com.example.finalprojectrealestateapplication.Service;

import com.example.finalprojectrealestateapplication.Entity.Booking;
import com.example.finalprojectrealestateapplication.Entity.Property;
import com.example.finalprojectrealestateapplication.Exception.ResourceNotFoundException;
import com.example.finalprojectrealestateapplication.Repository.PropertyRepository;
import com.example.finalprojectrealestateapplication.Request.BookingRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.finalprojectrealestateapplication.Repository.BookingRepository;

@Service
public class BookingService {
    @Autowired
    BookingRepository bookingRepository;


    public Booking getBooking(long bookingId) {
        Booking booking = bookingRepository.findById(bookingId).orElseThrow(() -> new ResourceNotFoundException("Booking id not found"));
        return booking;
    }

    public Booking updateBooking(long bookingId, BookingRequest bookingRequest){
        if(bookingRepository.existsById(bookingId)){
            Booking bookingToBeUpdated = new Booking(bookingRequest);
            bookingToBeUpdated.setId(bookingId);
            return bookingRepository.save(bookingToBeUpdated);
        }
        else{
            throw new ResourceNotFoundException("Booking id not found");
        }
    }


    public void deleteBooking(long bookingId) {
        if (bookingRepository.existsById(bookingId)) {
            bookingRepository.deleteById(bookingId);
        } else {
            throw new ResourceNotFoundException("Booking id not found");
        }

    }



}