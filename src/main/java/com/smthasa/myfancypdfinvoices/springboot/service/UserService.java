package com.smthasa.myfancypdfinvoices.springboot.service;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.smthasa.myfancypdfinvoices.springboot.model.User;

@Component
public class UserService {

    public User findById(String id) {
        String randomName = UUID.randomUUID().toString();
        // always "finds" the user, every user has a random name
        return new User(id, randomName);
    }
}
