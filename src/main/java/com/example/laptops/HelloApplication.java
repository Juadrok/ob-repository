package com.example.laptops;

import com.example.laptops.Entities.Laptop;
import com.example.laptops.Repositories.LaptopRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class HelloApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(HelloApplication.class, args);
		LaptopRepository repo = context.getBean(LaptopRepository.class);

		Laptop laptop1 = new Laptop(4,"Intel","Nvidia",500);
		Laptop laptop2 = new Laptop(8,"Intel","Intel Graphics",659);
		Laptop laptop3 = new Laptop(16,"AMD","Nvidia",10000);

		repo.save(laptop1);
		repo.save(laptop2);
		repo.save(laptop3);
	}



}
