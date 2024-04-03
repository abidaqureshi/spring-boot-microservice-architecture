package com.rakutan.usersservice.repositories;

import com.rakutan.usersservice.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

    //Custom method development
    //Write

}
