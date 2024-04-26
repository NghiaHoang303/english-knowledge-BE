package com.postgresql.englishpost.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.postgresql.englishpost.dto.PostDto;
import com.postgresql.englishpost.service.PostService;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/postskw")
public class PostKwController {
    private PostService postService;
    @PostMapping
    public ResponseEntity<PostDto> createPost (@RequestBody PostDto postDto) {
        PostDto savedPost = postService.createPost(postDto);
        return new ResponseEntity<>(savedPost, HttpStatus.CREATED);
    }

    // Build get Post by Id
    @GetMapping("{id}")
    public ResponseEntity<PostDto> getPostById (@PathVariable("id") Long postId) {
        PostDto postDto = postService.getPostById(postId);
        return  ResponseEntity.ok(postDto);
    }

    //Build get All post
    @GetMapping
    public ResponseEntity<List<PostDto>> getAllPosts() {
        List<PostDto> posts = postService.getAllPosts();
        return ResponseEntity.ok(posts);
    }

    @PutMapping("{id}")
    public ResponseEntity<PostDto> updatePost (@PathVariable("id") Long postId, @RequestBody PostDto updatePost) {
        PostDto postDto = postService.updatePost(postId, updatePost);
        return ResponseEntity.ok(postDto);
    }
}
