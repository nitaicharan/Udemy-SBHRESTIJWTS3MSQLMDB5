package com.nitaicharan.udemy_sbhrestijwts3msqlmdb5.resources.exception;

import lombok.Getter;

@Getter
public class StandardError {
	private Long timestamp;
	private Integer status;
	private String error;
	private String message;
	private String path;
}