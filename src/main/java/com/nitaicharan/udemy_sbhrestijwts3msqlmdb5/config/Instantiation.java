package com.nitaicharan.udemy_sbhrestijwts3msqlmdb5.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import com.nitaicharan.udemy_sbhrestijwts3msqlmdb5.domain.Post;
import com.nitaicharan.udemy_sbhrestijwts3msqlmdb5.domain.User;
import com.nitaicharan.udemy_sbhrestijwts3msqlmdb5.repository.PostRepository;
import com.nitaicharan.udemy_sbhrestijwts3msqlmdb5.repository.UserRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import lombok.AllArgsConstructor;

@Configuration
@AllArgsConstructor
public class Instantiation implements CommandLineRunner {

	private UserRepository userReposiroty;
	private PostRepository postReposiroty;

	@Override
	public void run(String... arg0) throws Exception {
		userReposiroty.deleteAll();
		postReposiroty.deleteAll();

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

		var maria = User.builder().name("Maria Brown").email("maria@gmail.com").build();
		var alex = User.builder().name("Alex Green").email("alex@gmail.com").build();
		var bob = User.builder().name("Bob Grey").email("bob@gmail.com").build();
		userReposiroty.saveAll(Arrays.asList(maria, alex, bob));

		var post1 = Post.builder().date(sdf.parse("21/03/2018")).title("Partiu viagem")
				.body("Vou viajar para São Paulo. Abraços!").author(maria).build();
		var post2 = Post.builder().date(sdf.parse("23/03/2018")).title("Bom dia").body("Acordei feliz hoje!")
				.author(maria).build();

		postReposiroty.saveAll(Arrays.asList(post1, post2));
	}

}