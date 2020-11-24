package com.nitaicharan.udemy_sbhrestijwts3msqlmdb5.domain;

import java.io.Serializable;

import lombok.Builder;

@Builder
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private String name;
    private String email;
}