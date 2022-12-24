package com.example.finalprojectrealestateapplication.Controller;

import com.example.finalprojectrealestateapplication.Entity.Property;
import com.example.finalprojectrealestateapplication.Request.BookingRequest;
import com.example.finalprojectrealestateapplication.Request.PropertyRequest;
import com.example.finalprojectrealestateapplication.Response.BookingResponse;
import com.example.finalprojectrealestateapplication.Response.PropertyResponse;
import com.example.finalprojectrealestateapplication.Service.PropertyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/properties")
public class PropertyController {
    @Autowired
    PropertyService propertyService;
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{listingId}/Bookings")
    public  BookingResponse addCourse(
            @PathVariable long listingId,
            @Valid @RequestBody BookingRequest bookingRequest
    ){
        return new BookingResponse(propertyService.addBooking(listingId, bookingRequest));
    }

    @GetMapping()
    public List<PropertyResponse> getAllProperties(@PathVariable long Id){
        List<Property> properties= propertyService.getAllProperties(Id);
        List<PropertyResponse> propertyResponse = new ArrayList<>();
        properties.forEach(property -> {
            propertyResponse.add(new PropertyResponse(property));
        });
return propertyResponse;



    }
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public PropertyResponse addProperty(
            @Valid @RequestBody PropertyRequest propertyRequest, @PathVariable long Id){
        Property property = propertyService.AddProperty(propertyRequest);
        return new PropertyResponse(property);

    }


// Deleting a property
    @DeleteMapping("/{Id}")
    public void deleteProperty(@PathVariable long Id)
    {
        propertyService.deleteProperty(Id);
    }



}



