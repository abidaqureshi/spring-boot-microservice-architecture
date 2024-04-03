package com.rakutan.usersservice.services;

import com.rakutan.usersservice.entities.User;


import java.util.List;


public interface UserService {

    User saveUser(User user);

    List<User> getAllUser();

    User getUser(String userId);

    Boolean updateUser (User user, String userId);

    Boolean deleteUser(String userId);
}
