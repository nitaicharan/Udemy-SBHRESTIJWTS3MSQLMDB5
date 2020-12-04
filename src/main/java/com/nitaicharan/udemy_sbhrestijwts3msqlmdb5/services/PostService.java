package com.nitaicharan.udemy_sbhrestijwts3msqlmdb5.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.nitaicharan.udemy_sbhrestijwts3msqlmdb5.domain.Post;
import com.nitaicharan.udemy_sbhrestijwts3msqlmdb5.repository.PostRepository;
import com.nitaicharan.udemy_sbhrestijwts3msqlmdb5.services.exception.ObjectNotFoundException;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PostService {

    private PostRepository repository;

    public Post findById(String id) {
        Optional<Post> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public List<Post> findByTitle(String text) {
        return repository.searchTitle(text);
    }

    public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
        maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
        return repository.fullSearch(text, minDate, maxDate);
    }
}