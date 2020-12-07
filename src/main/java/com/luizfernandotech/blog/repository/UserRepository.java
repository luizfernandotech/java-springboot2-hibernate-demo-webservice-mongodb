package com.luizfernandotech.blog.repository;

import com.luizfernandotech.blog.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
