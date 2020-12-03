package com.nitaicharan.udemy_sbhrestijwts3msqlmdb5.resources;

import java.util.List;

import com.nitaicharan.udemy_sbhrestijwts3msqlmdb5.domain.Post;
import com.nitaicharan.udemy_sbhrestijwts3msqlmdb5.services.PostService;
import com.nitaicharan.udemy_sbhrestijwts3msqlmdb5.util.URL;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/posts")
public class PostResource {

	private PostService service;

	@GetMapping("/{id}")
	public ResponseEntity<Post> findById(@PathVariable String id) {
		Post response = service.findById(id);
		return ResponseEntity.ok().body(response);
	}

	@GetMapping("/titlesearch")
	public ResponseEntity<List<Post>> findByTitle(@RequestParam(defaultValue = "") String text) {
		text = URL.decodeParam(text);
		List<Post> list = service.findByTitle(text);
		return ResponseEntity.ok().body(list);
	}
}