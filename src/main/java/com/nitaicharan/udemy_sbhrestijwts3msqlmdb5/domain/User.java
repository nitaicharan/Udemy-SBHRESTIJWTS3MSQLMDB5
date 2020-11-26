package com.nitaicharan.udemy_sbhrestijwts3msqlmdb5.domain;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;

@Builder
@Document
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private String name;
    private String email;
}