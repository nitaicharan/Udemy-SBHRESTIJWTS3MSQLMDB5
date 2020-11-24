package com.nitaicharan.udemy_sbhrestijwts3msqlmdb5.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.nitaicharan.udemy_sbhrestijwts3msqlmdb5.domain.User;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<User>> findAll() {
		User maria = User.builder().id("1").name("Maria Brown").email("maria@gmail.com").build();
		User alex = User.builder().id("2").name("Alex Green").email("alex@gmail.com").build();
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(maria, alex));
		return ResponseEntity.ok().body(list);
	}
}