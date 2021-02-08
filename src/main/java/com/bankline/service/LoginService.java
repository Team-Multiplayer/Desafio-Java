package com.bankline.service;

import com.bankline.exception.LoginOuSenhaInvalidosException;
import com.bankline.model.Usuario;
import com.bankline.repository.UsuarioRepository;

public class LoginService {
	
	private UsuarioRepository usuarioRepository = UsuarioRepository.getUsuarioRepository();
	
	public Usuario efetuarLogin(String login, String senha) {
		
		// busca um usuário pelo login
		Usuario usuario = usuarioRepository.buscaUsuarioPeloLogin(login);
		
		// se encontrou
		if (usuario != null) {
			// verifica se as senhas NÃO são iguais
			if (usuario.getSenha() != senha) {
				// lança uma exceção
				throw new LoginOuSenhaInvalidosException();
			}
		}
		// se tudo deu certo retorna o usuário logado	
		return usuario;
	}

}
