package com.example.finalprojectrealestateapplication.Response;

import com.example.finalprojectrealestateapplication.Entity.Booking;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookingResponse {

    private long id;

    private String firstName;

    private String lastName;
    private String email;

    private int phone;

    private String visitDate;

    private String message;

    public BookingResponse(Booking booking){
        id= booking.getId();
        firstName= booking.getFirstName();
        lastName= booking.getLastName();
        email= booking.getEmail();
        phone= booking.getPhone();
        visitDate= booking.getVisitDate();
        message= booking.getMessage();
    }


}
