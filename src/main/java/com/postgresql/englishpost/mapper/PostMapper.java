package com.postgresql.englishpost.mapper;

import com.postgresql.englishpost.dto.PostDto;
import com.postgresql.englishpost.entity.PostKw;

public class PostMapper {
    public static PostDto mapToPostDto(PostKw postKw) {
        return new PostDto(
            postKw.getId(),
            postKw.getTitle(),
            postKw.getDescription(),
            postKw.getAuthor(),
            postKw.getEmail()
        );
    }

    public static PostKw mapToPost(PostDto postDto) {
        return new PostKw(
            postDto.getId(),
            postDto.getTitle(),
            postDto.getDescription(),
            postDto.getAuthor(),
            postDto.getEmail()  
        );
    }
    
}
