package com.rakuten.hotelservices.repositories;

import com.rakuten.hotelservices.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, String> {
}
