package com.example.finalprojectrealestateapplication.Request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PropertyRequest {
    private int numOfBeds;
    private int numOfBaths;

    private double sqrtFoot;

    private double price;


    private String propertyType;


    private byte image;


    private String city;


}
