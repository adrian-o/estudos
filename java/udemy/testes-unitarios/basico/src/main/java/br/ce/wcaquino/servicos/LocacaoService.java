package br.ce.wcaquino.servicos;

import static br.ce.wcaquino.utils.DataUtils.adicionarDias;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import br.ce.wcaquino.entidades.Filme;
import br.ce.wcaquino.entidades.Locacao;
import br.ce.wcaquino.entidades.Usuario;
import br.ce.wcaquino.exceptions.FilmeSemEstoqueException;
import br.ce.wcaquino.exceptions.LocadoraException;
import br.ce.wcaquino.utils.DataUtils;

public class LocacaoService {
	
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
		
		Locacao locacao = new Locacao();
		locacao.setFilmes(filmes);
		locacao.setUsuario(usuario);
		locacao.setDataLocacao(new Date());
		locacao.setValor(0.0);
		
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
			
			locacao.setValor(locacao.getValor() + valorFilme);
		}
		
		//Entrega no dia seguinte
		Date dataEntrega = new Date();
		dataEntrega = adicionarDias(dataEntrega, 1);
		if (DataUtils.verificarDiaSemana(dataEntrega, Calendar.SUNDAY)) {
			dataEntrega = adicionarDias(dataEntrega, 1);
		}
		locacao.setDataRetorno(dataEntrega);
		
		//Salvando a locacao...	
		//TODO adicionar mÃ©todo para salvar
		
		return locacao;
	}

	/* Aula 3
	public static void main(String[] args) {
		// Cenário
		LocacaoService service = new LocacaoService();
		Usuario usuario = new Usuario("Adriano");
		Filme filme = new Filme("Dança do amanhã", 10, 4.5);
		
		// Ação
		Locacao locacao = service.alugarFilme(usuario, filme);
		
		// Verificação
		System.out.println(DataUtils.isMesmaData(locacao.getDataLocacao(), new Date()));
		System.out.println(locacao.getDataRetorno().after(new Date()));
		System.out.println(locacao.getValor() == filme.getPrecoLocacao());
	} */
	
	// Aula 4
//	@Test
//	public void testeLocacao() {
//		// Cenário
//		LocacaoService service = new LocacaoService();
//		Usuario usuario = new Usuario("Adriano");
//		Filme filme = new Filme("Dança do amanhã", 10, 4.5);
//		
//		// Ação
//		Locacao locacao = service.alugarFilme(usuario, filme);
//		
//		// Verificação
//		Assert.assertTrue(DataUtils.isMesmaData(locacao.getDataLocacao(), new Date()));
//		Assert.assertTrue(locacao.getDataRetorno().after(new Date()));
//		Assert.assertTrue(locacao.getValor() == filme.getPrecoLocacao()*2);
//	}

}