package com.nitaicharan.udemy_sbhrestijwts3msqlmdb5.resources;

import java.util.List;
import java.util.stream.Collectors;

import com.nitaicharan.udemy_sbhrestijwts3msqlmdb5.domain.User;
import com.nitaicharan.udemy_sbhrestijwts3msqlmdb5.dto.UserDTO;
import com.nitaicharan.udemy_sbhrestijwts3msqlmdb5.services.UserService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}