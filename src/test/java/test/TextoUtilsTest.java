package test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import desafio.utils.TextoUtils;

public class TextoUtilsTest {
	@Test
	public void loginComprimentoTest() {
		String nome="abc";
		assertTrue(TextoUtils.validaComprimento(nome, 3));
		
	}
	
	@Test
	public void loginComprimentoInvalidoTest() {
		String nome="abcd";
		assertFalse(TextoUtils.validaComprimento(nome, 3));
		
	}
}
