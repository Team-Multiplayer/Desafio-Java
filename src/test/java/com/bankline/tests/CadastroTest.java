package com.bankline.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.bankline.exception.LoginJaCadastradoException;
import com.bankline.model.Usuario;
import com.bankline.repository.UsuarioRepository;
import com.bankline.service.UsuarioService;

class CadastroTest {

	private UsuarioRepository ur = UsuarioRepository.getUsuarioRepository();
	private UsuarioService usuarioService = new UsuarioService();
	String nome;
	String cpf;
	String login;
	String senha;

	@BeforeEach
	void antesDeCadaTeste() {
		// inicia dados do usuário
		nome = "Danilo Elias";
		cpf = "37115975382";
		login = "danilo";
		senha = "pass1234";
		// limpa o repositório para os testes ficarem independentes
		ur.limparRepository();
	}

	@Test
	public void nomeNulo() {
		assertThrows(NullPointerException.class, () -> {
			nome = null;
			// cadastra um usuário com login nulo
			usuarioService.cadastrarUsuario(nome, cpf, login, senha);
		});
		
	}

	@Test
	public void cpfNulo() {
		assertThrows(NullPointerException.class, () -> {
			cpf = null;
			// cadastra um usuário com login nulo
			usuarioService.cadastrarUsuario(nome, cpf, login, senha);
		});
		
	}

	@Test
	public void loginNulo() {
		assertThrows(NullPointerException.class, () -> {
			login = null;
			// cadastra um usuário com login nulo
			usuarioService.cadastrarUsuario(nome, cpf, login, senha);
		});
		
	}

	@Test
	public void SenhaNula() {
		assertThrows(NullPointerException.class, () -> {
			senha = null;
			// cadastra um usuário com senha nula
			usuarioService.cadastrarUsuario(nome, cpf, login, senha);
		});
		
	}

	@Test
	public void loginForaDoPadrao() {
		assertThrows(IllegalArgumentException.class, () -> {
			// login com mais de 20 caracteres
			login = "123456789012345678901";
			// cadastra um usuário com login fora do pradrão desejado
			usuarioService.cadastrarUsuario(nome, cpf, login, senha);
		});
	}

	@Test
	public void cadastrarNovoUsuario() {
		// cadastra um usuário
		Usuario usuario = usuarioService.cadastrarUsuario(nome, cpf, login, senha);
		// deve retornar um usuário (não deve ser nulo)
		assertNotNull(usuario);
		assertEquals(usuario.getNome(), nome);
		assertEquals(usuario.getCpf(), cpf);
		assertEquals(usuario.getLogin(), login);
		assertEquals(usuario.getSenha(), senha);
	}

	@Test
	void loginJaCadastrado() {
		assertThrows(LoginJaCadastradoException.class, () -> {
			// cadastra um usuário
			usuarioService.cadastrarUsuario(nome, cpf, login, senha);
			// tenta cadastrar um usuário com o mesmo login
			usuarioService.cadastrarUsuario(nome, cpf, login, senha);
		});
	}


}
