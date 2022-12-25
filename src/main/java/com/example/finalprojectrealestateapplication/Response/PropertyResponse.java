package com.example.finalprojectrealestateapplication.Response;

import com.example.finalprojectrealestateapplication.Entity.Property;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PropertyResponse {
    private long id;
    private int numOfBeds;
    private int numOfBaths;

    private double sqrtFoot;

    private double price;


    private String propertyType;


    private byte image;


    private String city;


    public PropertyResponse(Property property){
        id=property.getId();
        numOfBeds=property.getNumOfBeds();
        numOfBaths=property.getNumOfBaths();
       sqrtFoot=property.getSqrtFoot();
       price= property.getPrice();
       propertyType=property.getPropertyType();
       image= property.getImage();
       city=property.getCity();
    }
}