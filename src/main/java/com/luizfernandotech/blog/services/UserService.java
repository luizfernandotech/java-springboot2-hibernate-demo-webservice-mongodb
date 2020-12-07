package com.luizfernandotech.blog.services;

import com.luizfernandotech.blog.entities.User;
import com.luizfernandotech.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }
}
