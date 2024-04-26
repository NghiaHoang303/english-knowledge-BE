package com.postgresql.englishpost.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.postgresql.englishpost.entity.PostKw;

@RepositoryRestResource
public interface PostRepository extends JpaRepository<PostKw, Long>{

    
} 