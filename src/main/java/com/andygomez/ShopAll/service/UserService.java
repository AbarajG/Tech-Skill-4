package com.andygomez.ShopAll.service;

import com.andygomez.ShopAll.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUser();
    User getUserById(Integer id);
    User createUser(User user);
    User updateUser(Integer id, User user);
    boolean deleteUser(Integer id);

}
