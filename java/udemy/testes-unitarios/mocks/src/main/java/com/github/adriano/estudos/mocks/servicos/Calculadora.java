package com.github.adriano.estudos.mocks.servicos;

import com.github.adriano.estudos.mocks.exceptions.NaoPodeDividirPorZeroException;

public class Calculadora {

	public int somar(int a, int b) {
		return a + b;
	}

	public int subtrair(int a, int b) {
		return a - b;
	}

	public int dividir(int a, int b) throws NaoPodeDividirPorZeroException {
		if (b == 0) throw new NaoPodeDividirPorZeroException(); 
		
		return a / b;
	}

}
