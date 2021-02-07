package com.bankline.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

class LoginTest {
	
	private static Map<String,String> usuarioRepositorio = new  HashMap<String, String>();
	
	@Test
	void loginExistente() {
		
		usuarioRepositorio.put("danilo", "pass1234");
		
		// busca um usuário com um login existente
		String usuario = usuarioRepositorio.get("danilo");
		
		// deve retornar um usuário
		assertNotNull(usuario);
	}

	@Test
	void loginNaoExistente() {
		
		usuarioRepositorio.put("danilo", "pass1234");
		
		// busca um usuário por um login não existente
		String usuario = usuarioRepositorio.get("lucas");
		
		// NÃO deve retornar um usuário
		assertNull(usuario);
	}

	@Test
	void senhaValida() {
		
		usuarioRepositorio.put("danilo", "pass1234");
		
		// busca um usuário por um login existente
		String senha = usuarioRepositorio.get("danilo");
		
		// compara a senha passada com a cadastrada
		Boolean senhaValida = (senha == "pass1234") ? true : false;
		
		// deve retornar verdadeiro
		assertTrue(senhaValida);
	}

	@Test
	void senhaInvalida() {
		
		usuarioRepositorio.put("danilo", "pass1234");
		
		// busca um usuário por um login existente
		String senha = usuarioRepositorio.get("danilo");
		
		// compara a senha passada com a cadastrada
		Boolean senhaValida = (senha == "1234pass") ? true : false;
		
		// deve retornar falso
		assertFalse(senhaValida);
	}
}
