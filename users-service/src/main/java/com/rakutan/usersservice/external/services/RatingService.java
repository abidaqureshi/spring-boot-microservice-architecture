package com.rakutan.usersservice.external.services;

import com.rakutan.usersservice.entities.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@Service
@FeignClient(name="RATINGSERVICE")
public interface RatingService {

    @GetMapping("/ratings/users/{userId}")
    Rating[] getRatings(@PathVariable("userId") String userId);

    @PostMapping("/ratings")
    public ResponseEntity<Rating> createRating(Rating rating);

    @PutMapping("/ratings/{ratingId}")
    public ResponseEntity<Rating> updateRating(@PathVariable("ratingId") String ratingId, Rating rating);

    @DeleteMapping("/ratings/{ratingId}")
    public void deleteRating(@PathVariable("ratingId") String ratingId);
}
