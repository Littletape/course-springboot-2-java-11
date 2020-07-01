package com.andersoncardosolima.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.andersoncardosolima.course.entities.User;
import com.andersoncardosolima.course.repositories.UserRepository;

@Configuration // anotação que informa ao Spring que esta é uma classe de configuração
@Profile("test") // indica que esse é um perfil de teste
public class TestConfig implements CommandLineRunner {

	@Autowired // anotação Spring para dependencia
	private UserRepository userRepository; // atributo da dependencia

	//executa operação em background ao rodar o programa
	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		userRepository.saveAll(Arrays.asList(u1, u2)); // repositorio salva no banco
	}

}
