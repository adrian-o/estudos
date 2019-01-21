package com.github.adriano.estudos.java.spring.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.adriano.estudos.java.spring.model.entity.Item;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel="itens",path="itens")
public interface ItemRepository extends JpaRepository<Item,	Long>	{
}