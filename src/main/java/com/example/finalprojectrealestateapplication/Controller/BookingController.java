package com.example.finalprojectrealestateapplication.Controller;

import com.example.finalprojectrealestateapplication.Request.BookingRequest;
import com.example.finalprojectrealestateapplication.Response.BookingResponse;
import com.example.finalprojectrealestateapplication.Service.BookingService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/Bookings")
public class BookingController {


    @Autowired
    private BookingService bookingService;

@GetMapping()
public BookingResponse getAllBookings(@PathVariable long bookingId){
    return new BookingResponse(bookingService.getBooking(bookingId));

}

    @PutMapping("/{bookingId}")
    public BookingResponse updateBooking(@PathVariable long bookingId, @Valid @RequestBody BookingRequest bookingRequest){
        return new BookingResponse(bookingService.updateBooking(bookingId, bookingRequest));
    }
    @DeleteMapping("/{bookingId}")
    public void deleteBooking(@PathVariable long bookingId){
        bookingService.deleteBooking(bookingId);
    }

}
