package com.rakuten.hotelservices.services;

import com.rakuten.hotelservices.entities.Hotel;

import java.util.List;

public interface HotelService {

    Hotel createHotel(Hotel hotel);

    Hotel getHotel(String id);

    List<Hotel> getAllHotels();

}
