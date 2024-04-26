package com.postgresql.englishpost.service.impl;

import com.postgresql.englishpost.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.postgresql.englishpost.dto.PostDto;
import com.postgresql.englishpost.entity.PostKw;
import com.postgresql.englishpost.mapper.PostMapper;
import com.postgresql.englishpost.repository.PostRepository;
import com.postgresql.englishpost.service.PostService;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor

public class PostServiceImpl implements PostService {
    private PostRepository postRepository;

    @Override
    public PostDto createPost(PostDto postDto) {
        PostKw post = PostMapper.mapToPost(postDto);
        PostKw savedPost =  postRepository.save(post);
        return PostMapper.mapToPostDto(savedPost);
    }

    @Override
    public PostDto getPostById(Long postId) {
        PostKw post = postRepository.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("Post is not exists with given id"+ postId));
        return PostMapper.mapToPostDto(post);
    }

    @Override
    public List<PostDto> getAllPosts() {
        List<PostKw> posts = postRepository.findAll();
        return posts.stream().map((post) -> PostMapper.mapToPostDto(post)).collect(Collectors.toList());
    }

    @Override
    public PostDto updatePost(Long postId, PostDto updatePost) {
        PostKw post = postRepository.findById(postId).orElseThrow(
                () -> new ResourceNotFoundException("Post is not exists with given id: " + postId)
        );
        post.setTitle(updatePost.getTitle());
        post.setAuthor(updatePost.getAuthor());
        post.setEmail(updatePost.getEmail());
        post.setDescription(updatePost.getDescription());

        PostKw updatedPostObj = postRepository.save(post);

        return PostMapper.mapToPostDto(updatedPostObj);
    }

}
