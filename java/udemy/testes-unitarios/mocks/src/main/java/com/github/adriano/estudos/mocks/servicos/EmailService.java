package com.github.adriano.estudos.mocks.servicos;

import com.github.adriano.estudos.mocks.entidades.Usuario;

public interface EmailService {
	
	public boolean notificarAtraso(Usuario usuario);
	
}