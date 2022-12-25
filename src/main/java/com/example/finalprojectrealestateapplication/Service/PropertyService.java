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

    // Adding a booking request
    public Booking addBooking (long listing_id, BookingRequest bookingRequest){
        Property property  =  propertyRepository.findById(listing_id).orElseThrow(
                ()->new ResourceNotFoundException("listing id is not found"));

        Booking bookingToBeSaved = new Booking(bookingRequest);
        bookingToBeSaved.setProperty(property);
        return bookingRepository.save(bookingToBeSaved);
    }

    // getting all the bookings
    public List<Booking> getAllBookings(long listingId){
        return bookingRepository.findAllByListingId(listingId);
    }
           // deleting Bookings


    public Property getPropertyById(long id){
        return propertyRepository.findById(id).orElseThrow(null);
    }

    // getting all properties by city name
    public List<Property> getAllPropertiesByCity(String city){
        if(city == null || city.isBlank())
            return (List<Property>) propertyRepository.findAll();
        else {
            return propertyRepository.findAllByCityIgnoreCase(city);
        }
    }



    public List<Property> getAllPropertiesByPrice(String price){
        if(price == null || price.isBlank())
            return (List<Property>) propertyRepository.findAll();
        else {
            return propertyRepository.findAllByPrice(price);
        }
    }


    // Adding  property
    public Property AddProperty(  PropertyRequest propertyRequest) {
        Property property = new Property();
        return propertyRepository.save(new Property(propertyRequest));
    }

    public Property updateProperty(long PropertyId, PropertyRequest propertyRequest) {
      propertyRepository.findById(PropertyId)
              .orElseThrow(()-> new ResourceNotFoundException("Property id is not found"));
      Property propertyToBeUpdated = new Property(propertyRequest);
      propertyToBeUpdated.setId(PropertyId);
      return propertyRepository.save(propertyToBeUpdated);
    }
    // deleting all the properties

    public void deleteProperty(long propertyId) {
        if (propertyRepository.existsById(propertyId)){
            propertyRepository.deleteById(propertyId);
        } else {
            throw new ResourceNotFoundException("property id not found");
        }

    }



    }

