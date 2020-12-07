package com.luizfernandotech.blog.repository;

import com.luizfernandotech.blog.entities.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}
