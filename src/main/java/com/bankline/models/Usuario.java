package com.bankline.models;

public class Usuario {
	String cpf;
	String nome;
	String login;
	String senha;
	
	public void Usuario(String cpf, String nome, String login, String senha) {
		this.cpf = cpf;
		this.nome = nome;
		this.login = login;
		this.senha = senha;
	}
}
