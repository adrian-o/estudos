package br.cd.wcaquino.servicos;

import org.junit.Assert;
import org.junit.Test;

import br.ce.wcaquino.entidades.Usuario;

public class AssertTest {

	@Test
	public void test() {
		Assert.assertTrue(true);
		Assert.assertFalse(false);
		
		Assert.assertEquals("Erro ao comparar inteiros...", 1, 2);
		
		Assert.assertEquals(0.114, 0.114434, 0.001);
		Assert.assertEquals(Math.PI, 3.14, 0.01);
		
		int i = 2;
		Integer i2 = 2;
		
		Assert.assertEquals(Integer.valueOf(i), i2);
		Assert.assertEquals(i, i2.intValue());
		
		Assert.assertEquals("bola", "bola");
		Assert.assertNotEquals("bOLa", "bola");
		
		Assert.assertTrue("bola".equalsIgnoreCase("Bola"));
		Assert.assertTrue("bola".startsWith("bo"));
	
		Usuario u1 = new Usuario("User1");
		Usuario u2 = new Usuario("User1");
		
		// Falha se o objeto não tiver o equals() implementado
		Assert.assertEquals(u1, u2);
		
		Assert.assertSame(u1, u1);
		
		Usuario u3 = u2; 
		
		Assert.assertSame(u3, u2);
		Assert.assertNotSame(u3, u1);
		
		Usuario u4 = null;
		
		Assert.assertNull(u4);
		Assert.assertNotNull(u3);
		Assert.assertTrue(u4 == null);
		
	
	}
}
