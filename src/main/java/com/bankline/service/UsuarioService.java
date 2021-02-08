package com.bankline.service;

import com.bankline.exception.LoginJaCadastradoException;
import com.bankline.model.Usuario;
import com.bankline.repository.UsuarioRepository;

public class UsuarioService {

	private UsuarioRepository usuarioRepository = UsuarioRepository.getUsuarioRepository();
	
	public Usuario cadastrarUsuario(String nome, String cpf, String login, String senha) {
		// se algum dos parametros passados estiverem nulos
		if (nome == null || cpf == null || login == null || senha == null)
			// lança uma exceção 
			throw new NullPointerException();
		// se o login passar de 20 caracteres
		if (login.length() > 20)
			// lança uma exceção
			throw new IllegalArgumentException(login);

		// busca um usuário com o login passado
		Usuario usuarioExistente = this.usuarioRepository.buscaUsuarioPeloLogin(login);
		
		// se encontrou um usuário
		if (usuarioExistente != null)
			// lança uma exceção
			throw new LoginJaCadastradoException();
		
		// se deu tudo certo cadastra um novo usuário e o retorna
		return this.usuarioRepository.novoUsuario(nome, cpf, login, senha);
	}
	
}
