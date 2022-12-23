package com.example.finalprojectrealestateapplication.Entity;


import com.example.finalprojectrealestateapplication.Request.PropertyRequest;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@Entity
@NoArgsConstructor
public class Property {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long listingId;
    @Column(name = "num_Beds")
    private int numOfBeds;
    @Column( name ="num_Baths")
    private int numOfBaths;
    @Column(name ="sqrt_Foot")
    private double sqrtFoot;

    @Column(name ="price")
    private double price;

    @Column(name ="property_Type")
    private String propertyType;
    @Column(name ="image")
    private byte image;
    @Column(name ="city")
    private String city;
    public  Property(PropertyRequest propertyRequest){
        numOfBeds=propertyRequest.getNumOfBeds();
         numOfBaths= propertyRequest.getNumOfBaths();
         sqrtFoot=propertyRequest.getSqrtFoot();
         price=propertyRequest.getPrice();
         propertyType=propertyRequest.getPropertyType();
         image= propertyRequest.getImage();
         city=propertyRequest.getCity();

    }

}
