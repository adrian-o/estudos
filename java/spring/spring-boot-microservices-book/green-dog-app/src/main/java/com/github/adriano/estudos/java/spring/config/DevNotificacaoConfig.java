package com.github.adriano.estudos.java.spring.config;

import com.github.adriano.estudos.java.spring.dto.Notificacao;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("!prod")
public class DevNotificacaoConfig implements Notificacao {

	@Override
	public boolean envioAtivo() {
		return false;
	}

}
