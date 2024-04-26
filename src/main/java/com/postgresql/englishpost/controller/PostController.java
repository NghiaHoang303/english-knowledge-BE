package com.postgresql.englishpost.controller;

import org.springframework.web.bind.annotation.RestController;

import com.postgresql.englishpost.entity.PostKw;
import com.postgresql.englishpost.repository.PostRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class PostController {

    @Autowired
    PostRepository repo;
    
    @PostMapping("/addPost")
    public void postMethodName(@RequestBody PostKw post) {
        //TODO: process POST request
        repo.save(post);
        
    }
    
}
