package com.example.RatingService.Repository;

import com.example.RatingService.Entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingRepository extends JpaRepository<Rating,Long> {

     public Rating findByHotelId(Long hotelid);
}
