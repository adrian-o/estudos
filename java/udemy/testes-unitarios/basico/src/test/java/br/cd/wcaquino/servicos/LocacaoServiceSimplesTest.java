package br.cd.wcaquino.servicos;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

import br.ce.wcaquino.entidades.Filme;
import br.ce.wcaquino.entidades.Locacao;
import br.ce.wcaquino.entidades.Usuario;
import br.ce.wcaquino.servicos.LocacaoService;
import br.ce.wcaquino.utils.DataUtils;

public class LocacaoServiceSimplesTest {

	@Rule
	public ErrorCollector error = new ErrorCollector();
	
	// Aula 5
	@Test
	public void testeLocacao() throws Exception {
		// Cenário
		LocacaoService service = new LocacaoService();
		Usuario usuario = new Usuario("Adriano");
		Filme filme = new Filme("Dança do amanhã", 10, 4.6);
		
		// Ação
		Locacao locacao = service.alugarFilme(usuario, filme);
		
		// Verificação
		assertTrue(DataUtils.isMesmaData(locacao.getDataLocacao(), new Date()));
		assertTrue(locacao.getDataRetorno().after(new Date()));
		assertEquals(4.5, locacao.getValor(), 0.1);
		
		// Aula 7
		assertThat(locacao.getValor(), is(4.6));
		assertThat(locacao.getValor(), is(equalTo(4.6)));
		assertThat(locacao.getValor(), is(not(7.6)));
		
		// Aula 8 
		error.checkThat(locacao.getValor(), is(5.0));
		error.checkThat(locacao.getValor(), is(equalTo(4.6)));
		error.checkThat(locacao.getValor(), is(not(4.6)));
	}

}