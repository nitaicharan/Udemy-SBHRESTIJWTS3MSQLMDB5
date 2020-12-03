package com.nitaicharan.udemy_sbhrestijwts3msqlmdb5.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@Document
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private String name;
    private String email;

    @Builder.Default
    @DBRef(lazy = true)
    private List<Post> posts = new ArrayList<>();

    public void addAll(Post... p) {
        posts.addAll(Arrays.asList(p));
    }
}