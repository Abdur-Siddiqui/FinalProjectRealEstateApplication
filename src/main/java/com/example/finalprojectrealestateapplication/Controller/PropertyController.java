package com.example.finalprojectrealestateapplication.Controller;

import com.example.finalprojectrealestateapplication.Entity.Property;
import com.example.finalprojectrealestateapplication.Request.PropertyRequest;
import com.example.finalprojectrealestateapplication.Response.PropertyResponse;
import com.example.finalprojectrealestateapplication.Service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/properties")
public class PropertyController {
    @Autowired
    PropertyService propertyService;

    @GetMapping()
    public List<PropertyResponse> getAllProperties(){
        List<Property> properties= PropertyService.getAllProperties();
        List<PropertyResponse> propertyResponse = new ArrayList<>();
        properties.forEach(property -> {
            propertyResponse.add(new PropertyResponse(property));
        });
return propertyResponse;
    }


    @PostMapping()
    public void addProperty(@RequestBody PropertyRequest propertyRequest){

    }
}
