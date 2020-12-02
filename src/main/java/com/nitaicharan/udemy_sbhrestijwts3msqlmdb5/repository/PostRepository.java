package com.nitaicharan.udemy_sbhrestijwts3msqlmdb5.repository;

import com.nitaicharan.udemy_sbhrestijwts3msqlmdb5.domain.Post;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
}