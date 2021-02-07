package com.bankline.models;

public class Usuario {
	
	String nome;
	String cpf;
	String login; // pode ser o CPF, um telefone ou um apelido de até 20 caracteres
	String senha;
	
	public Usuario(String cpf, String nome, String login, String senha) {
		this.nome = nome;
		this.cpf = cpf;
		this.login = login;
		this.senha = senha;
	}
	
}
