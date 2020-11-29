package com.nitaicharan.udemy_sbhrestijwts3msqlmdb5.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CommentDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String text;
	private Date date;
	private AuthorDTO author;
}