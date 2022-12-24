package com.example.finalprojectrealestateapplication.Request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    @NotNull
    private double price;

    @NotNull
    private String propertyType;

    @NotNull
    private byte image;

    @NotBlank
    private String city;


}
