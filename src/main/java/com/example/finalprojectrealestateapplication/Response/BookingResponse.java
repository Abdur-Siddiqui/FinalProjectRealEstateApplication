package com.example.finalprojectrealestateapplication.Response;

import com.example.finalprojectrealestateapplication.Entity.Booking;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookingResponse {

    private long Id;

    private String firstName;

    private String lastName;
    private String email;

    private int phone;

    private String visitDate;

    private String message;

    public BookingResponse(Booking booking){
        Id= booking.getBookingId();
        firstName= booking.getFirstName();
        lastName= booking.getLastName();
        email= booking.getEmail();
        phone= booking.getPhone();
        visitDate= booking.getVisitDate();
        message= booking.getMessage();
    }


}
