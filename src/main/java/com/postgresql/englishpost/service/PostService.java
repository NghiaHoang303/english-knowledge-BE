package com.postgresql.englishpost.service;

import com.postgresql.englishpost.dto.PostDto;

import java.util.List;

public interface PostService {
    PostDto createPost(PostDto postDto);
    PostDto getPostById (Long postId);
    List<PostDto> getAllPosts();
    PostDto updatePost (Long postId, PostDto updatePost);
}
  

