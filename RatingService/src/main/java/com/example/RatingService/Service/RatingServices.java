package com.example.RatingService.Service;


import com.example.RatingService.Entity.Rating;
import com.example.RatingService.Repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingServices {

    @Autowired
    RatingRepository ratingRepository;

    public Rating addRating(Rating rating){

         return ratingRepository.save(rating);
    }

    public Rating getRatingByHotelId(Long hotelId){

        return ratingRepository.findByHotelId(hotelId);
    }

}
