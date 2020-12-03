package com.nitaicharan.udemy_sbhrestijwts3msqlmdb5.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import com.nitaicharan.udemy_sbhrestijwts3msqlmdb5.domain.Post;
import com.nitaicharan.udemy_sbhrestijwts3msqlmdb5.domain.User;
import com.nitaicharan.udemy_sbhrestijwts3msqlmdb5.dto.UserDTO;
import com.nitaicharan.udemy_sbhrestijwts3msqlmdb5.services.UserService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/users")
public class UserResource {

	private UserService service;

	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll() {
		var list = service.findAll().stream()//
				.map(UserDTO::new)//
				.collect(Collectors.toList());

		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable String id) {
		User dto = service.findById(id);
		return ResponseEntity.ok().body(new UserDTO(dto));
	}

	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody UserDTO dto) {
		var entity = service.insert(dto.toEntity());
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(entity.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update(@RequestBody UserDTO dto, @PathVariable String id) {
		User obj = dto.toEntity();
		obj.setId(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/{id}/posts")
	public ResponseEntity<List<Post>> findPosts(@PathVariable String id) {
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj.getPosts());
	}
}