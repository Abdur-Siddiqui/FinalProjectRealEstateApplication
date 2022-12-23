package com.example.finalprojectrealestateapplication.Controller;

import com.example.finalprojectrealestateapplication.Entity.Property;
import com.example.finalprojectrealestateapplication.Request.PropertyRequest;
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

    @GetMapping()
    public List<PropertyResponse> getAllProperties(@RequestParam(required = true) String city){
        List<Property> properties= PropertyService.getAllProperties(city);
        List<PropertyResponse> propertyResponse = new ArrayList<>();
        properties.forEach(property -> {
            propertyResponse.add(new PropertyResponse(property));
        });
return propertyResponse;

@PutMapping("/{Id}"){
    public Property updateProperty(@PathVariable long listingId, @Valid @RequestBody propertyRequest propertyRequest){
   Property updatedProperty = propertyService
            }
        }
    }


    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public PropertyResponse addProperty( @Valid @RequestBody PropertyRequest propertyRequest){
        Property property = propertyService.AddProperty(propertyRequest);
        return new PropertyResponse(property);
    }
}

