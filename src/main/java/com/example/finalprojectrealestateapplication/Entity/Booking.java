package com.example.finalprojectrealestateapplication.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table (  name = "Bookings")
public class Booking {
    @Id
    @GeneratedValue
    private long BookingId;
    @Column(name ="first_name")
    private String firstName;
    @Column(name ="last_name")
    private String lastName;
    @Column(name ="Email")
    private String email;
    @Column(name ="Phone")
    private int phone;
    @Column(name ="visit_Date")
    private String visitDate;
    @Column(name ="Message")
    private String message;

    @Column(name ="listing_Id")
    private String listing_Id;
}
