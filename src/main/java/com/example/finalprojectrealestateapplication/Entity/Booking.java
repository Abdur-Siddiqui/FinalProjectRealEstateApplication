package com.example.finalprojectrealestateapplication.Entity;
import com.example.finalprojectrealestateapplication.Request.BookingRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Setter
@Entity
@Table (  name = "Bookings")
@NoArgsConstructor
@AllArgsConstructor
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name ="first_name", nullable = false)
    private String firstName;
    @Column(name ="last_name", nullable = false)
    private String lastName;
    @Column(name ="Email", nullable = false)
    private String email;
    @Column(name ="Phone",nullable = false)
    private int phone;
    @Column(name ="visit_Date",nullable = false)
    private String visitDate;
    @Column(name ="Message",nullable = false)
    private String message;
    @ManyToOne(optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name ="listing_id")
    private Property property;

    public Booking(BookingRequest bookingRequest){
        firstName= bookingRequest.getFirstName();
        lastName= bookingRequest.getLastName();
        email=bookingRequest.getEmail();
        phone= bookingRequest.getPhone();
        visitDate= bookingRequest.getVisitDate();
        message= bookingRequest.getMessage();

    }
}