package br.cd.wcaquino.servicos;

import static junit.framework.Assert.fail;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import br.ce.wcaquino.entidades.Filme;
import br.ce.wcaquino.entidades.Usuario;
import br.ce.wcaquino.exceptions.FilmeSemEstoqueException;
import br.ce.wcaquino.exceptions.LocadoraException;
import br.ce.wcaquino.servicos.LocacaoService;

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
	public void testeLocacaoSemEstoqueErro() throws Exception {
		// Cen�rio
		Usuario usuario = new Usuario("Adriano");
		Filme filme = new Filme("Dan�a do amanh�", 1, 4.6);
		
		List<Filme> filmes = Arrays.asList(filme);
		
		// A��o
		service.alugarFilme(usuario, filmes);
	}
	
	@Test(expected=FilmeSemEstoqueException.class)
	public void testeLocacaoSemEstoqueElegante() throws Exception {
		// Cen�rio
		Usuario usuario = new Usuario("Adriano");
		Filme filme = new Filme("Dan�a do amanh�", 0, 4.6);
		
		List<Filme> filmes = Arrays.asList(filme);
		
		// A��o
		service.alugarFilme(usuario, filmes);
	}
	
	@Test
	public void testeLocacaoSemEstoqueRobusta() throws FilmeSemEstoqueException {
		// Cen�rio
		//Usuario usuario = new Usuario("Adriano");
		Filme filme = new Filme("Dan�a do amanh�", 1, 4.6);
		
		List<Filme> filmes = Arrays.asList(filme);
		
		// A��o
		try {
			service.alugarFilme(null, filmes);
			fail();
		} catch (LocadoraException e) {
			assertThat(e.getMessage(), is("Usu�rio vazio"));
		}
	}
	
	@Test
	public void testeLocacaoFilmeVazio() throws LocadoraException, FilmeSemEstoqueException {
		// Cen�rio
		Usuario usuario = new Usuario("Adriano");
		//Filme filme = new Filme("Dan�a do amanh�", 0, 4.6);
		
		expected.expect(LocadoraException.class);
		expected.expectMessage("Filme vazio");
		
		// A��o
		service.alugarFilme(usuario, null);
		
		System.out.println("Forma nova");
	}
	
}