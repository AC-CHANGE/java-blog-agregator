package com.test.jba.service;

import com.test.jba.entity.User;
import com.test.jba.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findAOne(int id) {
        return userRepository.findOne(id);
    }
}
