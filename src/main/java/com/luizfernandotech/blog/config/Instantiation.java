package com.luizfernandotech.blog.config;

import com.luizfernandotech.blog.dto.AuthorDTO;
import com.luizfernandotech.blog.dto.CommentDTO;
import com.luizfernandotech.blog.entities.Post;
import com.luizfernandotech.blog.entities.User;
import com.luizfernandotech.blog.repository.PostRepository;
import com.luizfernandotech.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.Instant;
import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();
        postRepository.deleteAll();

        User u1 = new User(null, "Maria Brown", "maria@gmail.com");
        User u2 = new User(null, "Alex Green", "alex@gmail.com");
        User u3 = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(u1, u2, u3));

        Post p1 = new Post(null, Instant.parse("2020-06-20T19:53:07Z"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(u1));
        Post p2 = new Post(null, Instant.parse("2020-06-21T00:00:00Z"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(u1));

        CommentDTO c1 = new CommentDTO("Boa viagem!", Instant.parse("2020-06-20T19:53:07Z"), new AuthorDTO(u2));
        CommentDTO c2 = new CommentDTO("Aproveite", Instant.parse("2020-06-20T19:53:07Z"), new AuthorDTO(u3));
        CommentDTO c3 = new CommentDTO("Tenha um ótimo dia", Instant.parse("2020-06-20T19:53:07Z"), new AuthorDTO(u2));

        p1.getComments().addAll(Arrays.asList(c1, c2));
        p2.getComments().addAll(Arrays.asList(c3));

        postRepository.saveAll(Arrays.asList(p1, p2));

        u1.getPosts().addAll(Arrays.asList(p1, p2));
        userRepository.save(u1);


    }
}
