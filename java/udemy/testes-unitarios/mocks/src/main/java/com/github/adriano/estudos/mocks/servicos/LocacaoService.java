package com.github.adriano.estudos.mocks.servicos;

import static com.github.adriano.estudos.mocks.utils.DataUtils.adicionarDias;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.github.adriano.estudos.mocks.daos.LocacaoDAO;
import com.github.adriano.estudos.mocks.entidades.Filme;
import com.github.adriano.estudos.mocks.entidades.Locacao;
import com.github.adriano.estudos.mocks.entidades.Usuario;
import com.github.adriano.estudos.mocks.exceptions.FilmeSemEstoqueException;
import com.github.adriano.estudos.mocks.exceptions.LocadoraException;
import com.github.adriano.estudos.mocks.utils.DataUtils;

public class LocacaoService {
	
	private SPCService spcService;
	
	private EmailService emailService;
	
	private LocacaoDAO dao;
	
	public Locacao alugarFilme(Usuario usuario, List<Filme> filmes) throws LocadoraException, FilmeSemEstoqueException {
		
		if (usuario == null) {
			throw new LocadoraException("Usuário vazio");
		}
		
		if (filmes == null || filmes.isEmpty()) {
			throw new LocadoraException("Filme vazio");
		}
		
		for (Filme filme: filmes) {
			if(filme.getEstoque() == 0) {
				throw new FilmeSemEstoqueException();
			}
		}
		
		boolean negativado = false; 
		
		try {
			negativado = spcService.possuiNegativacao(usuario);
		} catch (Exception e) {
			throw new LocadoraException("SPC com problemas, tente mais tarde.");
		}
		
		if(negativado) {
			throw new LocadoraException("Usuário Negativado");
		}
		
		Locacao locacao = new Locacao();
		locacao.setFilmes(filmes);
		locacao.setUsuario(usuario);
		locacao.setDataLocacao(obterData());
		locacao.setValor(calculaValorLocacao(filmes));
		
		//Entrega no dia seguinte
		Date dataEntrega = obterData();
		dataEntrega = adicionarDias(dataEntrega, 1);
		if (DataUtils.verificarDiaSemana(dataEntrega, Calendar.SUNDAY)) {
			dataEntrega = adicionarDias(dataEntrega, 1);
		}
		locacao.setDataRetorno(dataEntrega);
		
		//Salvando a locacao...	
		dao.salvar(locacao);
		
		return locacao;
	}

	protected Date obterData() {
		return new Date();
	}

	private Double calculaValorLocacao(List<Filme> filmes) {
		Double valorLocacao = 0.0;
		
		for (int i = 0; i < filmes.size(); i++) { 
			Double valorFilme = filmes.get(i).getPrecoLocacao();
			
			switch(i) {
				case 0: 
				case 1: break;
				case 2: valorFilme *= 0.75; break;
				case 3: valorFilme *= 0.5; break;
				case 4: valorFilme *= 0.25; break;
				default: valorFilme = 0.0; break;
			}
			
			valorLocacao += valorFilme;
		}
		return valorLocacao;
	}

	public void notificarAtrasos() {
		List<Locacao> locacoes = this.dao.obterLocacoesAtrasadas();
		for (Locacao locacao : locacoes) {
			if(locacao.getDataRetorno().before(obterData())) {
				this.emailService.notificarAtraso(locacao.getUsuario());
			}
		}
	}

	public void prorrogarLocacao(Locacao locacao, int dias ) {
		Locacao nova = new Locacao();
		nova.setUsuario(locacao.getUsuario());
		nova.setFilmes(locacao.getFilmes());
		nova.setDataLocacao(obterData());
		nova.setDataRetorno(DataUtils.obterDataComDiferencaDias(dias));
		nova.setValor(locacao.getValor()*dias);
		
		dao.salvar(nova);
	}
	
}