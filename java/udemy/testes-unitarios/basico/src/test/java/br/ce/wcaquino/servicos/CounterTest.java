package br.ce.wcaquino.servicos;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class CounterTest {

	private static int count;
	
	@BeforeClass
	public static void before() {
		System.out.println("Count inicia com o valor " + count);
	}
	
	@AfterClass
	public static void after() {
		System.out.println("Count terminou com o valor " + count);
	}
	
	@Test
	public void increment() {
		count += 1;
		System.out.println(count);
	}
	
	@Test
	public void increment1() {
		count += 1;
		System.out.println(count);
	}
	
	@Test
	public void increment2() {
		count += 1;
		System.out.println(count);
	}
	
	@Test
	public void increment3() {
		count += 1;
		System.out.println(count);
	}
	
	@Test
	public void increment4() {
		count += 1;
		System.out.println(count);
	}

}
