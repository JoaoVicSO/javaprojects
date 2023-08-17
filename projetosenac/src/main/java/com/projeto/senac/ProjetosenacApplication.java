package com.projeto.senac;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
@EntityScan(basePackages="com.projeto.senac.model")
@ComponentScan(basePackages="com.projeto.senac.*")
@SpringBootApplication

public class ProjetosenacApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetosenacApplication.class, args);
	}

}
