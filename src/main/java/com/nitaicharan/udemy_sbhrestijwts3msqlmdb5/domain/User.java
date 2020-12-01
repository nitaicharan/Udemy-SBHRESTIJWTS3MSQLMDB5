package com.nitaicharan.udemy_sbhrestijwts3msqlmdb5.domain;

import java.io.Serializable;

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
}