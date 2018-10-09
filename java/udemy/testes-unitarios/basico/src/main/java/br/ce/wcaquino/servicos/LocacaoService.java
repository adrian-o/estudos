package br.ce.wcaquino.servicos;

import static br.ce.wcaquino.utils.DataUtils.adicionarDias;

import java.util.Date;
import java.util.List;

import br.ce.wcaquino.entidades.Filme;
import br.ce.wcaquino.entidades.Locacao;
import br.ce.wcaquino.entidades.Usuario;
import br.ce.wcaquino.exceptions.FilmeSemEstoqueException;
import br.ce.wcaquino.exceptions.LocadoraException;

public class LocacaoService {
	
	public Locacao alugarFilme(Usuario usuario, List<Filme> filmes) throws LocadoraException, FilmeSemEstoqueException {
		
		if (usuario == null) {
			throw new LocadoraException("Usu�rio vazio");
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
		filmes.forEach((filme)->{ 
			locacao.setValor(locacao.getValor() + filme.getPrecoLocacao());
		});
		
		//Entrega no dia seguinte
		Date dataEntrega = new Date();
		dataEntrega = adicionarDias(dataEntrega, 1);
		locacao.setDataRetorno(dataEntrega);
		
		//Salvando a locacao...	
		//TODO adicionar método para salvar
		
		return locacao;
	}

	/* Aula 3
	public static void main(String[] args) {
		// Cen�rio
		LocacaoService service = new LocacaoService();
		Usuario usuario = new Usuario("Adriano");
		Filme filme = new Filme("Dan�a do amanh�", 10, 4.5);
		
		// A��o
		Locacao locacao = service.alugarFilme(usuario, filme);
		
		// Verifica��o
		System.out.println(DataUtils.isMesmaData(locacao.getDataLocacao(), new Date()));
		System.out.println(locacao.getDataRetorno().after(new Date()));
		System.out.println(locacao.getValor() == filme.getPrecoLocacao());
	} */
	
	// Aula 4
//	@Test
//	public void testeLocacao() {
//		// Cen�rio
//		LocacaoService service = new LocacaoService();
//		Usuario usuario = new Usuario("Adriano");
//		Filme filme = new Filme("Dan�a do amanh�", 10, 4.5);
//		
//		// A��o
//		Locacao locacao = service.alugarFilme(usuario, filme);
//		
//		// Verifica��o
//		Assert.assertTrue(DataUtils.isMesmaData(locacao.getDataLocacao(), new Date()));
//		Assert.assertTrue(locacao.getDataRetorno().after(new Date()));
//		Assert.assertTrue(locacao.getValor() == filme.getPrecoLocacao()*2);
//	}

}