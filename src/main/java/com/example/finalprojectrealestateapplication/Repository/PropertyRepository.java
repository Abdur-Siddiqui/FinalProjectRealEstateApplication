package com.example.finalprojectrealestateapplication.Repository;

import com.example.finalprojectrealestateapplication.Entity.Property;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyRepository extends CrudRepository<Property, Long> {

}
