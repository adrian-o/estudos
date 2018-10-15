package br.ce.wcaquino.servicos;

import static br.ce.wcaquino.builders.FilmeBuilder.umFilme;
import static br.ce.wcaquino.builders.FilmeBuilder.umFilmeSemEstoque;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.junit.Assume.assumeTrue;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import br.ce.wcaquino.builders.UsuarioBuilder;
import br.ce.wcaquino.entidades.Filme;
import br.ce.wcaquino.entidades.Locacao;
import br.ce.wcaquino.entidades.Usuario;
import br.ce.wcaquino.exceptions.FilmeSemEstoqueException;
import br.ce.wcaquino.exceptions.LocadoraException;
import br.ce.wcaquino.matchers.MatcherProprio;
import br.ce.wcaquino.utils.DataUtils;

public class LocacaoServiceTest {

	private LocacaoService service;
	
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
		assertThat(loc.getValor(), is(5.0));
	}
	
	@Test(expected=FilmeSemEstoqueException.class)
	public void naoDeveAlugarFilmeSemEstoque() throws Exception {
		// cenário
		Usuario usuario = UsuarioBuilder.umUsuario().agora();
		Filme filme = umFilmeSemEstoque().agora();
		
		List<Filme> filmes = Arrays.asList(filme);
		
		// ação
		service.alugarFilme(usuario, filmes);
	}
	
	@Test
	public void naoDeveAlugarFilmeSemUsuario() throws FilmeSemEstoqueException {
		// cenariio
		Filme filme = umFilme().agora();
		
		List<Filme> filmes = Arrays.asList(filme);
		
		// ação
		try {
			service.alugarFilme(null, filmes);
			fail();
		} catch (LocadoraException e) {
			assertThat(e.getMessage(), is("Usuário vazio"));
		}
	}
	
	@Test
	public void naoDeveAlugarFilmeSemFilme() throws LocadoraException, FilmeSemEstoqueException {
		// cenário
		Usuario usuario = UsuarioBuilder.umUsuario().agora();
		
		expected.expect(LocadoraException.class);
		expected.expectMessage("Filme vazio");
		
		// ação
		service.alugarFilme(usuario, null);
	}
	
	
	/** ########################### TDD ########################## 
	 * @throws FilmeSemEstoqueException 
	 * @throws LocadoraException */
	
	@Test
	public void deveDarDesconto25PctFilme3() throws LocadoraException, FilmeSemEstoqueException {
		// cenário
		Usuario usuario = UsuarioBuilder.umUsuario().agora();
		Filme filme = umFilme().agora();
		Filme filme2 = umFilme().agora();
		Filme filme3 = umFilme().agora();
		
		List<Filme> filmes = Arrays.asList(filme, filme2, filme3);
		
		// ação
		Locacao loc = service.alugarFilme(usuario, filmes);
		
		// validação
		assertThat(loc.getValor(), is(13.75));
	}
	
	@Test
	public void deveDarDesconto50PctFilme4() throws LocadoraException, FilmeSemEstoqueException {
		// cenário
		Usuario usuario = UsuarioBuilder.umUsuario().agora();
		Filme filme = umFilme().agora();
		Filme filme2 = umFilme().agora();
		Filme filme3 = umFilme().agora();
		Filme filme4 = umFilme().agora();
		
		List<Filme> filmes = Arrays.asList(filme, filme2, filme3, filme4);
		
		// ação
		Locacao loc = service.alugarFilme(usuario, filmes);
		
		// validação
		assertThat(loc.getValor(), is(16.25));
	}
	
	@Test
	public void deveDarDesconto75PctFilme5() throws LocadoraException, FilmeSemEstoqueException {
		// cenário
		Usuario usuario = UsuarioBuilder.umUsuario().agora();
		Filme filme = umFilme().agora();
		Filme filme2 = umFilme().agora();
		Filme filme3 = umFilme().agora();
		Filme filme4 = umFilme().agora();
		Filme filme5 = umFilme().agora();
		
		List<Filme> filmes = Arrays.asList(filme, filme2, filme3, filme4, filme5);
		
		// ação
		Locacao loc = service.alugarFilme(usuario, filmes);
		
		// validação
		assertThat(loc.getValor(), is(17.50));
	}
	
	@Test
	public void deveDarDescontoTotalAPartirDoFilme6() throws LocadoraException, FilmeSemEstoqueException {
		// cenário
		Usuario usuario = UsuarioBuilder.umUsuario().agora();
		Filme filme = umFilme().agora();
		Filme filme2 = umFilme().agora();
		Filme filme3 = umFilme().agora();
		Filme filme4 = umFilme().agora();
		Filme filme5 = umFilme().agora();
		Filme filme6 = umFilme().agora();
		
		List<Filme> filmes = Arrays.asList(filme, filme2, filme3, filme4, filme5, filme6);
		
		// ação
		Locacao loc = service.alugarFilme(usuario, filmes);
		
		// validação
		assertThat(loc.getValor(), is(17.50));
	}
	
	@Test
	public void deveDevolverNaSegundaQuandoAlugarNoSabado() throws LocadoraException, FilmeSemEstoqueException {
		assumeTrue(DataUtils.verificarDiaSemana(new Date(), Calendar.SATURDAY));
		
		// cenário
		Usuario usuario = UsuarioBuilder.umUsuario().agora();
		Filme filme = umFilme().agora();
		List<Filme> filmes = Arrays.asList(filme);
		
		//ação
		Locacao loc = service.alugarFilme(usuario, filmes);
		
		//validação
		//boolean ehSegunda = DataUtils.verificarDiaSemana(loc.getDataRetorno(), Calendar.MONDAY);
		//assertTrue(ehSegunda);
		assertThat(loc.getDataRetorno(), MatcherProprio.caiEm(Calendar.MONDAY));
		assertThat(loc.getDataRetorno(), MatcherProprio.caiSegunda());
	}
}