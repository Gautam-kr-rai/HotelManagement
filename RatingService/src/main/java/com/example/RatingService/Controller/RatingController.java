package com.example.RatingService.Controller;


import com.example.RatingService.Entity.Rating;
import com.example.RatingService.Service.RatingServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rating")
public class RatingController {

    @Autowired
    RatingServices ratingServices;

    @PostMapping("/addRating")
    public ResponseEntity<Rating> addRating(@RequestBody Rating rating){

            Rating ratingNew = ratingServices.addRating(rating);

        return new ResponseEntity<>(ratingNew, HttpStatus.CREATED);
    }

   @GetMapping("/getRatingByHotelId/{hotelId}")
    public ResponseEntity<Float> getRatingByHotelId(@PathVariable Long hotelId){

       Rating rating =    ratingServices.getRatingByHotelId(hotelId);

       return new ResponseEntity<>(rating.getHotelActualRating(), HttpStatus.OK);
    }
}
