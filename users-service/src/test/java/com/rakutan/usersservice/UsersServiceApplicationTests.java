package com.rakutan.usersservice;

import com.rakutan.usersservice.entities.Rating;
import com.rakutan.usersservice.external.services.RatingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

@SpringBootTest
class UsersServiceApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private RatingService ratingService;

//	@Test
//	void createRating() {
//		Rating rating = Rating.builder().rating(10).userId("").hotelId("").feedback("this is created using fiegn client").build();
//		ResponseEntity<Rating> ratingResponseEntity = ratingService.createRating(rating)
//		Rating saveRating = ratingService.createRating(rating);
//		System.out.println("new rating created");

//	}

}
