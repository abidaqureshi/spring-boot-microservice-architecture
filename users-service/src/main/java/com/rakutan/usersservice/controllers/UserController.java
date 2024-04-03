package com.rakutan.usersservice.controllers;


import com.rakutan.usersservice.entities.User;
import com.rakutan.usersservice.services.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    //Create
    @PostMapping
    public ResponseEntity<User> createUser (@RequestBody User user) {
        User userSaved = this.userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(userSaved);
    }

    int retryCount = 1;
    //Single user get
    @GetMapping("/{userId}")
    //@CircuitBreaker(name="ratingHotelBreaker",fallbackMethod = "ratingHotelFallback")
    //@Retry(name = "ratingHotelService", fallbackMethod = "ratingHotelFallback")
    @RateLimiter(name="userRateLimiter", fallbackMethod = "ratingHotelFallback")
    public ResponseEntity<User> getUser(@PathVariable String userId) {
        //logger.info("Retry count: {}", retryCount);
        //retryCount++;
        logger.info("Rate limiter is invoked");
        User user = this.userService.getUser(userId);
        return ResponseEntity.ok(user);
    }

    //creating fall back method for circuit breaker
    public ResponseEntity<User> ratingHotelFallback(String userId, Exception ex) {

        //ex.printStackTrace();
        //logger.info("Fallback is executed because service is down: ", ex.getMessage());

        User user = User.builder().userId("12344").email("dummy@gmail.com").name("Dummy").about("This is created dummy becuase some service is down").build();
        return new ResponseEntity<>(user, HttpStatus.OK);
    }


    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = this.userService.getAllUser();
        return ResponseEntity.ok(users);
    }

    //all user get
}
