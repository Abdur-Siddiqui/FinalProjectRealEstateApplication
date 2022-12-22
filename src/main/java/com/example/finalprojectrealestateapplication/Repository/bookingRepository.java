package com.example.finalprojectrealestateapplication.Repository;

import com.example.finalprojectrealestateapplication.Entity.Booking;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface bookingRepository extends CrudRepository<Booking, Long> {


}
