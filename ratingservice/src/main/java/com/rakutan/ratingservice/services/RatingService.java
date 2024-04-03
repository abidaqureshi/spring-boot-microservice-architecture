package com.rakutan.ratingservice.services;

import com.rakutan.ratingservice.entities.Rating;


import java.util.List;


public interface RatingService {

    //Create
    Rating create(Rating rating);

    //get all ratings
    List<Rating> getRatings();

    //get all by UserId
    List<Rating> getRatingByUserId(String userId);

    // get all by hotel
    List<Rating> getRatingByHotelId(String hotelId);



}
