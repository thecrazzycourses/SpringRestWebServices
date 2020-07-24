package com.carzzy.rahul.service;

import com.carzzy.rahul.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User save(User user);
    Optional<User> findById(Long id);
    List<User> findAll();
    void delete(Long id);

}
