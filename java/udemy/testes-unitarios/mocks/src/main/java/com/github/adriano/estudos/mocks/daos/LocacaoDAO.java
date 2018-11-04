package com.github.adriano.estudos.mocks.daos;

import java.util.List;

import com.github.adriano.estudos.mocks.entidades.Locacao;

public interface LocacaoDAO {

	public void salvar(Locacao locacao);

	public List<Locacao> obterLocacoesAtrasadas();
}
