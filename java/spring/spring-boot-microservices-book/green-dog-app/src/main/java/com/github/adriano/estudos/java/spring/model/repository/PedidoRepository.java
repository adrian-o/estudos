package com.github.adriano.estudos.java.spring.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.adriano.estudos.java.spring.model.entity.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
	
}