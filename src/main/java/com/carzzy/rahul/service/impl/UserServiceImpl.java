package com.carzzy.rahul.service.impl;

import com.carzzy.rahul.entity.User;
import com.carzzy.rahul.repository.UserRepository;
import com.carzzy.rahul.service.UserService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User save(User user) {
        User savedUser = null;
        if (user.getId() == null) {
            savedUser = userRepository.save(user);
        }
        return savedUser;
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public void delete(Long id) {
        Optional<User> byId = userRepository.findById(id);
        userRepository.delete(byId.get());
    }
}
