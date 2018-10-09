package br.ce.wcaquino.servicos;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.ce.wcaquino.exceptions.NaoPodeDividirPorZeroException;

public class CalculadoraTest {

	private Calculadora calc;
	
	@Before
	public void before() {
		calc = new Calculadora();
	}
	
	@Test
	public void deveSomarDoisValores() {
		// Cenario
		int a = 5;
		int b = 3;
		
		// Acao
		int res = calc.somar(a,b);
		
		// Validacao
		Assert.assertEquals(8, res);
	}
	
	@Test
	public void deveSubtrairDoisValores() {
		// Cenario
		int a = 5;
		int b = 3;
		
		// Acao
		int res = calc.subtrair(a,b);
		
		// Validacao
		Assert.assertEquals(2, res);
	}
	
	@Test
	public void deveDividirDoisValores() throws NaoPodeDividirPorZeroException {
		// Cenario
		int a = 6;
		int b = 3;
		
		// Acao
		int res = calc.dividir(a,b);
		
		// Validacao
		Assert.assertEquals(2, res);
	}
	
	@Test(expected=NaoPodeDividirPorZeroException.class)
	public void deveLancarExcecaoDividirPorZero() throws NaoPodeDividirPorZeroException {
		// Cenario
		int a = 6;
		int b = 0;
		
		// Acao
		calc.dividir(a,b);
	}
}
