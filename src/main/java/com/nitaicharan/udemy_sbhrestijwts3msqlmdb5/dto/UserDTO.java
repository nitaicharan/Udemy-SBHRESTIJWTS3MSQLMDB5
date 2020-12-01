package com.nitaicharan.udemy_sbhrestijwts3msqlmdb5.dto;

import com.nitaicharan.udemy_sbhrestijwts3msqlmdb5.domain.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    private String id;
    private String name;
    private String email;

    public UserDTO(User entity) {
        id = entity.getId();
        name = entity.getName();
        email = entity.getEmail();
    }

    public User toEntity() {
        return User.builder()//
                .id(id)//
                .name(name)//
                .email(email)//
                .build();
    }
}