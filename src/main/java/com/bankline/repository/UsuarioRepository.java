package com.bankline.repository;

import java.util.HashMap;
import java.util.Map;

import com.bankline.model.Usuario;

public class UsuarioRepository {
	
	// singleton
	private static UsuarioRepository instance;
	// repositório
	private static Map<String, Usuario> repository;
	
	// cria o repositório
	private UsuarioRepository() {
		repository = new HashMap<String, Usuario>();
	}
	
	// pega a instância única do repositório
	public static UsuarioRepository getUsuarioRepository() {
		if (instance == null)
			instance = new UsuarioRepository();
//		repository.clear();
		return instance;
	}
	
	// limpa o repositório
	public void limparRepository() {
		repository.clear();
	}
	
	public Usuario buscaUsuarioPeloLogin(String login) {
		return repository.get(login);
	}
	
	public Usuario novoUsuario(String nome, String cpf, String login, String senha) {
		// cria um novo usuário
		Usuario novoUsuario = new Usuario(nome, cpf, login, senha);
		// adiciona no repositório
		repository.put(login, novoUsuario);
		// retorna o usuário cadastrado
		return repository.get(login);
	}

}
