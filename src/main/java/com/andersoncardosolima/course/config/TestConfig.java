package com.andersoncardosolima.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.andersoncardosolima.course.entities.Category;
import com.andersoncardosolima.course.entities.Order;
import com.andersoncardosolima.course.entities.OrderItem;
import com.andersoncardosolima.course.entities.Payment;
import com.andersoncardosolima.course.entities.Product;
import com.andersoncardosolima.course.entities.User;
import com.andersoncardosolima.course.entities.enums.OrderStatus;
import com.andersoncardosolima.course.repositories.CategoryRepository;
import com.andersoncardosolima.course.repositories.OrderItemRepository;
import com.andersoncardosolima.course.repositories.OrderRepository;
import com.andersoncardosolima.course.repositories.ProductRepository;
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

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;

	// executa operação em background ao rodar o programa
	@Override
	public void run(String... args) throws Exception {

		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");

		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
		

		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3)); // repositorio salva no banco
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
		//relacinando os produtos com as categorias
		p1.getCategories().add(cat2);
		p2.getCategories().add(cat1);
		p2.getCategories().add(cat3);
		p3.getCategories().add(cat3);
		p4.getCategories().add(cat3);
		p5.getCategories().add(cat2);
		
		// repositorio salva no banco os relacionamentos na tabela especificada
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

		// as datas estão no padrão iso 8601
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u1);

		userRepository.saveAll(Arrays.asList(u1, u2)); // repositorio salva no banco
		orderRepository.saveAll(Arrays.asList(o1, o2, o3)); // repositorio salva no banco
		
		OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
		OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
		OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
		OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());
		
		orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));
		
		// instacia o pagamento e armazena em seu respectivo pedido
		Payment pay1 = new Payment(null, Instant.parse("2019-06-20T21:53:07Z"), o1);
		o1.setPayment(pay1);
		
		orderRepository.save(o1); // repositorio salva no banco
	}

}
