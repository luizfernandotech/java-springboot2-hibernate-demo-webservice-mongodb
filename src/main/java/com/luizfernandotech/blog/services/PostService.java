package com.luizfernandotech.blog.services;

import com.luizfernandotech.blog.entities.Post;
import com.luizfernandotech.blog.repository.PostRepository;
import com.luizfernandotech.blog.services.exeption.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    PostRepository repository;

    public Post findById(String id) {
        Optional<Post> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
    }

    public List<Post> findByTitle(String text) {
        return repository.searchByTitle(text);
    }

    public List<Post> fullSearch(String text, Instant minDate, Instant maxDate) {
        maxDate = maxDate.plus(24, ChronoUnit.HOURS);
        return repository.fullSearch(text, minDate, maxDate);
    }
}
