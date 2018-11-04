package com.github.adriano.estudos.mocks.servicos;

import com.github.adriano.estudos.mocks.entidades.Usuario;

public interface SPCService {
	
	public boolean possuiNegativacao(Usuario usuario) throws Exception;
	
}