package com.lucasberlanda.gerenciadorcatalogo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class GerenciadorCatalogoApplication {

	public static void main(String[] args) {
		SpringApplication.run(GerenciadorCatalogoApplication.class, args);
	}

}
