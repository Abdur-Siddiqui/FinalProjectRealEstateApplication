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
    private long Id;
    @Column(name = "num_Beds", nullable = false)
    private int numOfBeds;
    @Column( name ="num_Baths", nullable = false)
    private int numOfBaths;
    @Column(name ="sqrt_Foot", nullable = false)
    private double sqrtFoot;

    @Column(name ="price",nullable = false)
    private double price;

    @Column(name ="property_Type",nullable = false)
    private String propertyType;
    @Column(name ="image",nullable = false)
    private byte image;
    @Column(name ="city",nullable = false)
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
