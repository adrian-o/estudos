package com.github.adriano.estudos.java.spring.config;

import com.github.adriano.estudos.java.spring.domain.Item;
import com.github.adriano.estudos.java.spring.repository.ClienteRepository;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;
import org.springframework.stereotype.Component;

@Component
public class SpringDataRestCustomization 
extends RepositoryRestConfigurerAdapter 
{

	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
		config.exposeIdsFor(Item.class, ClienteRepository.class);
	}
}
