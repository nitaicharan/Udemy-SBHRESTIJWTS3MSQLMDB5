package com.nitaicharan.udemy_sbhrestijwts3msqlmdb5.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.nitaicharan.udemy_sbhrestijwts3msqlmdb5.dto.AuthorDTO;
import com.nitaicharan.udemy_sbhrestijwts3msqlmdb5.dto.CommentDTO;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@Document
public class Post implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	private Date date;
	private String title;
	private String body;
	private AuthorDTO author;
	@Builder.Default
	private List<CommentDTO> comments = new ArrayList<>();
}