package com.nitaicharan.udemy_sbhrestijwts3msqlmdb5.dto;

import java.io.Serializable;

import com.nitaicharan.udemy_sbhrestijwts3msqlmdb5.domain.User;

import lombok.Getter;

@Getter
public class AuthorDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;
	private String name;

	public AuthorDTO(User obj) {
		id = obj.getId();
		name = obj.getName();
	}
}