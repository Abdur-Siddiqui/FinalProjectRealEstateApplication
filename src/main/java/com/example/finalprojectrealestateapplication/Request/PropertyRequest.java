package com.example.finalprojectrealestateapplication.Request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PropertyRequest {
    @NotBlank
    private int numOfBeds;
    @NotBlank
    private int numOfBaths;
    @NotBlank
    private double sqrtFoot;
    @NotBlank
    private double price;

    @NotBlank
    private String propertyType;

    @NotBlank
    private byte image;

    @NotBlank
    private String city;


}
