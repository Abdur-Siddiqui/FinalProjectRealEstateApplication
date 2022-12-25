package com.example.finalprojectrealestateapplication.Controller;

import com.example.finalprojectrealestateapplication.Entity.Booking;
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
@CrossOrigin("*")
@RequestMapping("/api/Properties")
public class PropertyController {
    @Autowired
    PropertyService propertyService;
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{listing_Id}/Bookings")
    public  BookingResponse addBooking(
            @PathVariable long listing_Id,
            @Valid @RequestBody BookingRequest bookingRequest
    ){
        return new BookingResponse(propertyService.addBooking(listing_Id, bookingRequest));
    }

    // get all bookings

    @GetMapping("/{listingId}/Bookings")
    public List<BookingResponse> getAllBookings(@PathVariable long listingId){
        List<Booking> bookings = propertyService.getAllBookings(listingId);
        List<BookingResponse> bookingResponses = new ArrayList<>();
        for(int i =0; i<bookings.size(); i++){
            bookingResponses.add(new BookingResponse(bookings.get(i)));
        }
        return bookingResponses;
    }


    @GetMapping("/city/{city}")
    public List<PropertyResponse> getAllPropertiesByCity( @PathVariable String city){
        List<Property> properties= propertyService.getAllPropertiesByCity(city);
        List<PropertyResponse> propertyResponse = new ArrayList<>();
        properties.forEach(property -> {
            propertyResponse.add(new PropertyResponse(property));
        });
return propertyResponse;

    }


    @GetMapping("/price/{price}")
    public List<PropertyResponse> getAllPropertiesByPrice( @PathVariable String price){
        List<Property> properties= propertyService.getAllPropertiesByPrice(price);
        List<PropertyResponse> propertyResponse = new ArrayList<>();
        properties.forEach(property -> {
            propertyResponse.add(new PropertyResponse(property));
        });
        return propertyResponse;

    }
    // creating a property
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public PropertyResponse addProperty(
            @Valid @RequestBody PropertyRequest propertyRequest, @PathVariable long Id){
        Property property = propertyService.AddProperty(propertyRequest);
        return new PropertyResponse(property);

    }
// updating a property
@PutMapping("/{id}")
public PropertyResponse updateProperty(@PathVariable long id,
                                       @Valid @RequestBody PropertyRequest propertyRequest){
        Property updatedProperty = propertyService.updateProperty(id, propertyRequest);
        return new PropertyResponse(updatedProperty);
}
// Deleting a property
    @DeleteMapping("/{id}")
    public void deleteProperty(@PathVariable long id)
    {
        propertyService.deleteProperty(id);
    }



}



