package com.example.finalprojectrealestateapplication.Repository;

import com.example.finalprojectrealestateapplication.Entity.Booking;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends CrudRepository<Booking, Long> {
    List<Booking> findByListingId(long Id);
    void deleteByListingId(long Id);


}
