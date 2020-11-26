package com.nitaicharan.udemy_sbhrestijwts3msqlmdb5.config;

import java.util.Arrays;

import com.nitaicharan.udemy_sbhrestijwts3msqlmdb5.domain.User;
import com.nitaicharan.udemy_sbhrestijwts3msqlmdb5.repository.UserRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import lombok.AllArgsConstructor;

@Configuration
@AllArgsConstructor
public class Instantiation implements CommandLineRunner {

	private UserRepository repository;

	@Override
	public void run(String... arg0) throws Exception {
		repository.deleteAll();
		
		var maria = User.builder().name("Maria Brown").email("maria@gmail.com").build();
		var alex = User.builder().name("Alex Green").email("alex@gmail.com").build();
		var bob = User.builder().name("Bob Grey").email("bob@gmail.com").build();
		repository.saveAll(Arrays.asList(maria, alex, bob));
	}

}