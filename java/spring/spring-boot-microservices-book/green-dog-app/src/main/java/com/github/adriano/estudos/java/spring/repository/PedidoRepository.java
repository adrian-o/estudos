package com.github.adriano.estudos.java.spring.repository;

import com.github.adriano.estudos.java.spring.domain.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
 
	 
}
