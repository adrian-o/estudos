package br.ce.wcaquino.servicos;

import static br.ce.wcaquino.builders.FilmeBuilder.umFilme;
import static br.ce.wcaquino.matchers.MatcherProprio.ehHojeComDiferencaDeDias;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.rules.ExpectedException;

import br.ce.wcaquino.builders.UsuarioBuilder;
import br.ce.wcaquino.entidades.Filme;
import br.ce.wcaquino.entidades.Locacao;
import br.ce.wcaquino.entidades.Usuario;

public class ComparacaoDatasTest {

	private LocacaoService service;
	
	@Rule
	public ErrorCollector error = new ErrorCollector();
	
	@Rule
	public ExpectedException expected = ExpectedException.none();
	
	@Before
	public void setup() {
		service = new LocacaoService();
	}
	
	// Aula 9
	@Test
	public void deveAlugarFilme() throws Exception {
		// cenário
		Usuario usuario = UsuarioBuilder.umUsuario().agora();
		Filme filme = umFilme().agora();
		
		List<Filme> filmes = Arrays.asList(filme);
		
		// ação
		Locacao loc = service.alugarFilme(usuario, filmes);
		
		// validação
		error.checkThat(loc.getDataRetorno(), ehHojeComDiferencaDeDias(1));
	}
}