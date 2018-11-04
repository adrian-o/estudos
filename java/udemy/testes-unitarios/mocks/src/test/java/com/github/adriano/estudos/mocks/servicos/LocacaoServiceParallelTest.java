package com.github.adriano.estudos.mocks.servicos;

import static com.github.adriano.estudos.mocks.builders.FilmeBuilder.umFilme;
import static com.github.adriano.estudos.mocks.builders.FilmeBuilder.umFilmeSemEstoque;
import static com.github.adriano.estudos.mocks.builders.LocacaoBuilder.umaLocacao;
import static com.github.adriano.estudos.mocks.builders.UsuarioBuilder.umUsuario;
import static com.github.adriano.estudos.mocks.matchers.MatcherProprio.ehHojeComDiferencaDeDias;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.times;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import com.github.adriano.estudos.mocks.builders.UsuarioBuilder;
import com.github.adriano.estudos.mocks.daos.LocacaoDAO;
import com.github.adriano.estudos.mocks.entidades.Filme;
import com.github.adriano.estudos.mocks.entidades.Locacao;
import com.github.adriano.estudos.mocks.entidades.Usuario;
import com.github.adriano.estudos.mocks.exceptions.FilmeSemEstoqueException;
import com.github.adriano.estudos.mocks.exceptions.LocadoraException;
import com.github.adriano.estudos.mocks.matchers.MatcherProprio;
import com.github.adriano.estudos.mocks.runners.ParallelRunner;
import com.github.adriano.estudos.mocks.utils.DataUtils;

//@RunWith(ParallelRunner.class)
public class LocacaoServiceParallelTest {

	@InjectMocks @Spy
	private LocacaoService service;
	
	@Mock
	private SPCService spcService;
	
	@Mock
	private EmailService emailService;
	
	@Mock
	private LocacaoDAO locacaoDAO;
	
	@Rule
	public ExpectedException expected = ExpectedException.none();
	
	@Rule
	public ErrorCollector error = new ErrorCollector();
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		System.out.println("Iniciando Test Parallel...");
	}
	
	@After
	public void tearDown() {
		System.out.println("Finalizando Test Parallel...");
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
	public void deveDevolverNaSegundaQuandoAlugarNoSabado() throws Exception {
		// cenário
		Usuario usuario = UsuarioBuilder.umUsuario().agora();
		Filme filme = umFilme().agora();
		List<Filme> filmes = Arrays.asList(filme);
		
		Mockito.doReturn(DataUtils.obterData(29, 4, 2017)).when(service).obterData();

		//ação
		Locacao loc = service.alugarFilme(usuario, filmes);
		
		//validação
		assertThat(loc.getDataRetorno(), MatcherProprio.caiEm(Calendar.MONDAY));
		assertThat(loc.getDataRetorno(), MatcherProprio.caiSegunda());
		
	}
	
	@Test
	public void naoDeveAlugarFilmeParaUsuarioNegativado() throws Exception {
		// cenário 
		Usuario usuario = UsuarioBuilder.umUsuario().agora();
		Filme filme = umFilme().agora();
		List<Filme> filmes = Arrays.asList(filme);
		
		Mockito.when(spcService.possuiNegativacao(usuario)).thenReturn(true);
		
		expected.expect(LocadoraException.class);
		expected.expectMessage("Usuário Negativado");
		
		// ação
		service.alugarFilme(usuario, filmes);
		
		// validação
		Mockito.verify(spcService).possuiNegativacao(usuario);
	}
	
	@Test
	public void deveEnviarEmailParaLocacoesAtrasadas() {
		// cenário 
		Usuario usuario = umUsuario().agora();
		Usuario usuario2 = umUsuario().comNome("Usuario 2").agora();
		Usuario usuario3 = umUsuario().comNome("Usuario 3").agora();
		List<Locacao> pendentes = 
				Arrays.asList(umaLocacao().atrasada(-2).comUsuario(usuario).agora(),
						umaLocacao().comUsuario(usuario2).agora(),
						umaLocacao().atrasada(-3).comUsuario(usuario3).agora());
		
		Mockito.when(locacaoDAO.obterLocacoesAtrasadas()).thenReturn(pendentes);
		
		// ação
		this.service.notificarAtrasos();
		
		// validação
		//Mockito.verify(emailService).notificarAtraso(usuario);
		//Mockito.verify(emailService, Mockito.never()).notificarAtraso(usuario2);
		//Mockito.verify(emailService).notificarAtraso(usuario3);
		
		Mockito.verify(emailService, times(2)).notificarAtraso(Mockito.any(Usuario.class));
		
		Mockito.verifyNoMoreInteractions(emailService);
	}
	
	@Test
	public void deveTratarErroNoRetornoDoSPC() throws Exception {
		// cenário
		Usuario usuario = UsuarioBuilder.umUsuario().agora();
		List<Filme> filmes = Arrays.asList(umFilme().agora());
		
		Mockito.when(spcService.possuiNegativacao(usuario)).thenThrow(new Exception("Falha catastrófica"));
		
		// validação
		expected.expect(LocadoraException.class);
		expected.expectMessage("SPC com problemas, tente mais tarde.");
		
		// ação
		service.alugarFilme(usuario, filmes);
	}
	
	@Test
	public void deveProrrogarUmaLocacao() {
		Locacao loc = umaLocacao().agora();
		
		service.prorrogarLocacao(loc, 3);
		
		ArgumentCaptor<Locacao> argCapt = ArgumentCaptor.forClass(Locacao.class);
		Mockito.verify(locacaoDAO).salvar(argCapt.capture());
		Locacao locRet = argCapt.getValue();
		
		error.checkThat(locRet.getValor(), is(15.0));
		error.checkThat(locRet.getDataRetorno(), ehHojeComDiferencaDeDias(3));
	}
	
	/**
	 * PowerMock mockando métodos privdos...
	 * @throws Exception
	 */
	@Test
	public void deveCalcularValorLocacao() throws Exception {
		// cenário
		List<Filme> filmes = Arrays.asList(umFilme().agora(), umFilme().agora());
		
		// ação
		Class<LocacaoService> clazz = LocacaoService.class;
		Method metodo = clazz.getDeclaredMethod("calculaValorLocacao", List.class);
		metodo.setAccessible(true);
		Double valorLoc = (Double) metodo.invoke(service, filmes);
		
		// validação
		assertThat(valorLoc, is(5.0*filmes.size()));
	}
}