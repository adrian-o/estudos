package com.github.adriano.estudos.java.spring.util;

import com.github.adriano.estudos.java.spring.domain.Cliente;
import com.github.adriano.estudos.java.spring.domain.Pedido;
import com.github.adriano.estudos.java.spring.dto.Notificacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EnviaNotificacao {

    @Autowired
	Notificacao notificacao;
    
	public void enviaEmail(Cliente cliente, Pedido pedido) {
		
		System.out.println("Enviar notificacao para "+cliente.getNome() + " - pedido $"+pedido.getValorTotal());
		
		if (notificacao.envioAtivo()) {
			
			/*
			     codigo de envio
			 */
			
			System.out.println("Notificacao enviada!");
			
		} else {
			
			System.out.println("Notificacao desligada!");
		
		}
	}
	
	
}
