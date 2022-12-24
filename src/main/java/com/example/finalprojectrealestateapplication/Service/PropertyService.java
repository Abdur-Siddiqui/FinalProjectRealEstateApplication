package com.example.finalprojectrealestateapplication.Service;

import com.example.finalprojectrealestateapplication.Entity.Booking;
import com.example.finalprojectrealestateapplication.Entity.Property;
import com.example.finalprojectrealestateapplication.Exception.ResourceNotFoundException;
import com.example.finalprojectrealestateapplication.Repository.BookingRepository;
import com.example.finalprojectrealestateapplication.Repository.PropertyRepository;
import com.example.finalprojectrealestateapplication.Request.BookingRequest;
import com.example.finalprojectrealestateapplication.Request.PropertyRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyService {

    @Autowired

    PropertyRepository propertyRepository;

    @Autowired
    BookingRepository bookingRepository;

    public List<Property> getAllProperties(long listingId) {
        return (List<Property>) propertyRepository.findAll();
    }

    public Property AddProperty(PropertyRequest propertyRequest) {
        Property property = new Property();
        return propertyRepository.save(new Property(propertyRequest));
    }


    public Booking addBooking (long listingId, BookingRequest bookingRequest){
        Property property  =  propertyRepository.findById(listingId).orElseThrow(
                ()->new ResourceNotFoundException("listing id is not found"));

        Booking bookingToBeSaved = new Booking(bookingRequest);
        bookingToBeSaved.setProperty(property);

        return bookingRepository.save(bookingToBeSaved);
    }


    public Property updateProperty(long Id, PropertyRequest propertyRequest) {
        Property propertyToBeUpdated = new Property(propertyRequest);
        propertyToBeUpdated.setId(Id);
        return propertyRepository.save(propertyToBeUpdated);
    }

    public void deleteProperty(long Id) {
        if (propertyRepository.existsById(Id)) {
            propertyRepository.deleteById(Id);
        } else {
            throw new ResourceNotFoundException("property id not found");
        }

    }
}
