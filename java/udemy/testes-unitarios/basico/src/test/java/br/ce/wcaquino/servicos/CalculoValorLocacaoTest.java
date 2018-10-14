package br.ce.wcaquino.servicos;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import br.ce.wcaquino.entidades.Filme;
import br.ce.wcaquino.entidades.Locacao;
import br.ce.wcaquino.entidades.Usuario;
import br.ce.wcaquino.exceptions.FilmeSemEstoqueException;
import br.ce.wcaquino.exceptions.LocadoraException;

@RunWith(Parameterized.class)
public class CalculoValorLocacaoTest {

	private LocacaoService service;
	
	@Parameter
	public List<Filme> filmes;
	
	@Parameter(value=1)
	public Double valorLocacao;
	
	@Parameter(value=2)
	public String descricao;
	
	@Rule
	public ExpectedException expected = ExpectedException.none();
	
	@Before
	public void setup() {
		service = new LocacaoService();
	}
	
	private static Filme f1 = new Filme("Dança do amanhã", 5, 5.0);
	private static Filme f2 = new Filme("Dança do amanhã II", 8, 5.0); 
	private static Filme f3 = new Filme("Dança do depois amanhã", 3, 5.0);
	private static Filme f4 = new Filme("Dança dos Lobos", 3, 5.0);
	private static Filme f5 = new Filme("Dança dos Lobos II", 3, 5.0);
	private static Filme f6 = new Filme("Novo filme surpresa", 3, 5.0);
	
	@Parameters(name="{2}")
	public static Collection<Object[]> getParametros() {
		return Arrays.asList(new Object[][] {
			{Arrays.asList(f1, f2)                , 10.00, "2 filmes: Sem desconto"},
			{Arrays.asList(f1, f2, f3)            , 13.75, "3 filmes: 25%"},
			{Arrays.asList(f1, f2, f3, f4)        , 16.25, "4 filmes: 50%"},
			{Arrays.asList(f1, f2, f3, f4, f5)    , 17.50, "5 filmes: 75%"},
			{Arrays.asList(f1, f2, f3, f4, f5, f6), 17.50, "6 filmes: 100%"}
		});
	}
	
	@Test
	public void deveCalcularValorLocacaoConsiderandoDescontos() throws LocadoraException, FilmeSemEstoqueException {
		// cenário
		Usuario usuario = new Usuario("Adriano");
		
		// ação
		Locacao loc = service.alugarFilme(usuario, filmes);
		
		// validação
		assertThat(loc.getValor(), is(valorLocacao));
	}
	
	@Test
	public void print() {
		System.out.println(valorLocacao);
	}
}