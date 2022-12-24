package com.example.finalprojectrealestateapplication.Repository;

import com.example.finalprojectrealestateapplication.Entity.Property;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PropertyRepository extends CrudRepository<Property, Long> {
    List<Property> findAllByCityAndPriceAndNumOfBeds(String city, double price, int NumOfBeds);

}
