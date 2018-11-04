package com.github.adriano.estudos.mocks.servicos;

import static com.github.adriano.estudos.mocks.builders.FilmeBuilder.umFilme;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

import com.github.adriano.estudos.mocks.builders.UsuarioBuilder;
import com.github.adriano.estudos.mocks.daos.LocacaoDAO;
import com.github.adriano.estudos.mocks.entidades.Filme;
import com.github.adriano.estudos.mocks.entidades.Locacao;
import com.github.adriano.estudos.mocks.entidades.Usuario;
import com.github.adriano.estudos.mocks.matchers.MatcherProprio;
import com.github.adriano.estudos.mocks.utils.DataUtils;

@RunWith(PowerMockRunner.class)
@PrepareForTest(LocacaoService.class)
public class LocacaoServiceTestPowerMock {

	@InjectMocks
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
		service = PowerMockito.spy(service);
	}
	
	@Test
	public void deveDevolverNaSegundaQuandoAlugarNoSabado() throws Exception {
		// cenário
		Usuario usuario = UsuarioBuilder.umUsuario().agora();
		Filme filme = umFilme().agora();
		List<Filme> filmes = Arrays.asList(filme);
		
		PowerMockito.whenNew(Date.class).withNoArguments().thenReturn(DataUtils.obterData(29, 4, 2017));
		
		// Caso as datas tivessem sido criadas usando um Calendar...
//		Calendar calendar = Calendar.getInstance();
//		calendar.set(Calendar.DAY_OF_MONTH, 29);
//		calendar.set(Calendar.MONTH, 4);
//		calendar.set(Calendar.YEAR, 2017);
//		
//		PowerMockito.mockStatic(Calendar.class);
//		PowerMockito.when(Calendar.getInstance()).thenReturn(calendar);
		
		//ação
		Locacao loc = service.alugarFilme(usuario, filmes);
		
		//validação
		//boolean ehSegunda = DataUtils.verificarDiaSemana(loc.getDataRetorno(), Calendar.MONDAY);
		//assertTrue(ehSegunda);
		assertThat(loc.getDataRetorno(), MatcherProprio.caiEm(Calendar.MONDAY));
		assertThat(loc.getDataRetorno(), MatcherProprio.caiSegunda());
		
//		PowerMockito.verifyStatic(Mockito.times(2));
//		Calendar.getInstance();
	}
	
	/**
	 * PowerMock mockando métodos privdos...
	 * @throws Exception
	 */
	@Test
	public void deveAlugarFilme_SemCalculoValorLocacao() throws Exception {
		// cenário
		Usuario usuario = UsuarioBuilder.umUsuario().agora();
		List<Filme> filmes = Arrays.asList(umFilme().agora());
		
		PowerMockito.doReturn(1.0).when(service, "calculaValorLocacao", filmes);
		
		// ação
		Locacao loc = service.alugarFilme(usuario, filmes);
		
		// validação
		assertThat(loc.getValor(), is(1.0));
		PowerMockito.verifyPrivate(service).invoke("calculaValorLocacao", filmes);
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
		Double valorLoc = (Double) Whitebox.invokeMethod(service, "calculaValorLocacao", filmes);
		
		// validação
		assertThat(valorLoc, is(5.0*filmes.size()));
	}
}