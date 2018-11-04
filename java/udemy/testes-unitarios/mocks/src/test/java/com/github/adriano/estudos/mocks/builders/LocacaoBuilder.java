package com.github.adriano.estudos.mocks.builders;

import static com.github.adriano.estudos.mocks.builders.FilmeBuilder.umFilme;
import static com.github.adriano.estudos.mocks.builders.UsuarioBuilder.umUsuario;
import static java.util.Arrays.asList;

import java.util.Date;

import com.github.adriano.estudos.mocks.entidades.Locacao;
import com.github.adriano.estudos.mocks.entidades.Usuario;
import com.github.adriano.estudos.mocks.utils.DataUtils;

public class LocacaoBuilder {
	
	private Locacao locacao;
	
	private LocacaoBuilder() {}
	
	public static LocacaoBuilder umaLocacao() {
		LocacaoBuilder builder = new LocacaoBuilder();
		builder.locacao = new Locacao();
		builder.locacao.setUsuario(umUsuario().agora());
		builder.locacao.setFilmes(asList(umFilme().agora()));
		builder.locacao.setDataLocacao(new Date());
		builder.locacao.setDataRetorno(DataUtils.obterDataComDiferencaDias(1));
		builder.locacao.setValor(5.0d);
		return builder;
	}
	
	public  LocacaoBuilder atrasada(Integer dias) {
		locacao.setDataLocacao(DataUtils.obterDataComDiferencaDias(dias-2));
		locacao.setDataRetorno(DataUtils.obterDataComDiferencaDias(dias));
		return this;
	}
	
	public  LocacaoBuilder comUsuario(Usuario usuario) {
		locacao.setUsuario(usuario);
		return this;
	}
	
	public Locacao agora() {
		return this.locacao;
	}
}
