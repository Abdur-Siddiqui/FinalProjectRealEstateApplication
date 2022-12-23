package com.example.finalprojectrealestateapplication.Service;

import com.example.finalprojectrealestateapplication.Entity.Property;
import com.example.finalprojectrealestateapplication.Repository.PropertyRepository;
import com.example.finalprojectrealestateapplication.Request.PropertyRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyService {

    @Autowired

    PropertyRepository propertyRepository;

    public List<Property> getAllProperties(String cityParam){
        return (List<Property>)  propertyRepository.findAll();
    }

    public Property AddProperty(PropertyRequest propertyRequest){
        return propertyRepository.save(new Property(propertyRequest));
    }

    public Property updateProperty(long listingId, PropertyRequest propertyRequest)
    {
       Property propertyToBeUpdated = new Property(propertyRequest);
       propertyToBeUpdated.setListingId(listingId);
       return propertyRepository.save(propertyToBeUpdated);
    }

}
