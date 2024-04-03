package com.rakutan.usersservice.services.Impl;

import com.rakutan.usersservice.entities.Hotel;
import com.rakutan.usersservice.entities.Rating;
import com.rakutan.usersservice.entities.User;
import com.rakutan.usersservice.exceptions.ResourceNotFoundException;
import com.rakutan.usersservice.external.services.HotelService;
import com.rakutan.usersservice.external.services.RatingService;
import com.rakutan.usersservice.repositories.UserRepository;
import com.rakutan.usersservice.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HotelService hotelService;

    @Autowired
    private RatingService ratingService;

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public User saveUser(User user) {

        String randomUserId = UUID.randomUUID().toString();
        user.setUserId(randomUserId);
        return this.userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return this.userRepository.findAll();
    }

    @Override
    public User getUser(String userId) {
        User user = this.userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException());

        //http://localhost:8083/ratings/users/561d20bc-5be2-40b2-b747-041a4e48a162
        //Rating[] ratingOfUsers = restTemplate.getForObject("http://RATINGSERVICE/ratings/users/"+user.getUserId(), Rating[].class);
        Rating[] ratingOfUsers = ratingService.getRatings(user.getUserId());
        logger.info("{} ",ratingOfUsers);

        List<Rating> ratingListUsers = Arrays.stream(ratingOfUsers).toList();

       List<Rating> ratingList = ratingListUsers.stream().map(rating->{
           //api call to hotel service to get the hotel

           //http://localhost:8082/hotels/97d83246-902f-4206-bf31-5ba3f6cf4588

           //ResponseEntity<Hotel> hotelResponseEntity = restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/"+rating.getHotelId(), Hotel.class);
            Hotel hotel = hotelService.getHotel(rating.getHotelId());
            //logger.info("response status code ", hotelResponseEntity.getStatusCode());
           //set the hotel to rating
           rating.setHotel(hotel);
           return rating;
        }).collect(Collectors.toList());
        user.setRatings(ratingList);
        return user;
    }

    @Override
    public Boolean updateUser(User user, String userId) {
        return null;
    }

    @Override
    public Boolean deleteUser(String userId) {
        return null;
    }
}
