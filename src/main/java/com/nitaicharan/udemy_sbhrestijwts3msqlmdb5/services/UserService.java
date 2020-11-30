package com.nitaicharan.udemy_sbhrestijwts3msqlmdb5.services;

import java.util.List;

import com.nitaicharan.udemy_sbhrestijwts3msqlmdb5.domain.User;
import com.nitaicharan.udemy_sbhrestijwts3msqlmdb5.repository.UserRepository;
import com.nitaicharan.udemy_sbhrestijwts3msqlmdb5.services.exception.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> findAll() {
        return repo.findAll();
    }

    public User findById(String id) {
        var optional = repo.findById(id);
        return optional.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public User insert(User obj) {
        return repo.insert(obj);
    }
}