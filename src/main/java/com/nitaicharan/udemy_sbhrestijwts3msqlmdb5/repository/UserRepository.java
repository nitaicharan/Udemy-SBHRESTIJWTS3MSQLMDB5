package com.nitaicharan.udemy_sbhrestijwts3msqlmdb5.repository;

import com.nitaicharan.udemy_sbhrestijwts3msqlmdb5.domain.User;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}