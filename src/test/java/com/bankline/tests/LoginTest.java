package com.bankline.tests;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.bankline.exception.LoginOuSenhaInvalidosException;
import com.bankline.model.Usuario;
import com.bankline.repository.UsuarioRepository;
import com.bankline.service.LoginService;
import com.bankline.service.UsuarioService;

class LoginTest {
	
	private UsuarioRepository ur = UsuarioRepository.getUsuarioRepository();
	private LoginService loginService = new LoginService();
	private UsuarioService usuarioService = new UsuarioService();
	String nome;
	String cpf;
	String login;
	String senha;

	@BeforeEach
	void limparUsuarioRepository() {
		// inicia dados do usuário
		nome = "Danilo Elias";
		cpf = "37115975382";
		login = "danilo";
		senha = "pass1234";
		// limpa o repositório para os testes ficarem independentes
		ur.limparRepository();
	}
	
	@Test
	void loginNaoExistente() {
		// busca o usuário com o login NÃO cadastrado
		Usuario usuario = loginService.efetuarLogin(login, senha);
		// NÃO deve retornar um usuário
		assertNull(usuario);
	}

	@Test
	void loginExistente() {
		// cadastra o usuário
		usuarioService.cadastrarUsuario(nome, cpf, login, senha);
		// busca o usuário com o login cadastrado
		Usuario usuario = loginService.efetuarLogin(login, senha);
		// deve retornar um usuário
		assertNotNull(usuario);
	}

	@Test
	void senhaInvalida() {
		assertThrows(LoginOuSenhaInvalidosException.class, () -> {
			String senhaInvalida = "1234pass";
			// cadastra o usuário
			usuarioService.cadastrarUsuario(nome, cpf, login, senha);
			// busca o usuário com o login cadastrado mas a senha inválida
			Usuario usuario = loginService.efetuarLogin(login, senhaInvalida);
		});
	}

	@Test
	void senhaValida() {
		assertDoesNotThrow(() -> {
			// cadastra o usuário
			usuarioService.cadastrarUsuario(nome, cpf, login, senha);
			// busca o usuário com o login cadastrado mas a senha inválida
			Usuario usuario = loginService.efetuarLogin(login, senha);
			// deve retornar um usuário
			assertNotNull(usuario);
			assertEquals(usuario.getLogin(), login);
		});
	}

}
