package com.andersoncardosolima.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.andersoncardosolima.course.entities.Category;
import com.andersoncardosolima.course.entities.Order;
import com.andersoncardosolima.course.entities.User;
import com.andersoncardosolima.course.entities.enums.OrderStatus;
import com.andersoncardosolima.course.repositories.CategoryRepository;
import com.andersoncardosolima.course.repositories.OrderRepository;
import com.andersoncardosolima.course.repositories.UserRepository;

@Configuration // anotação que informa ao Spring que esta é uma classe de configuração
@Profile("test") // indica que esse é um perfil de teste
public class TestConfig implements CommandLineRunner {

	@Autowired // anotação Spring para dependencia
	private UserRepository userRepository; // atributo da dependencia
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;

	//executa operação em background ao rodar o programa
	@Override
	public void run(String... args) throws Exception {

		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3)); // repositorio salva no banco
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

		// as datas estão no padrão iso 8601
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u1);
		
		userRepository.saveAll(Arrays.asList(u1, u2)); // repositorio salva no banco
		
		orderRepository.saveAll(Arrays.asList(o1, o2, o3)); // repositorio salva no banco
	}

}
