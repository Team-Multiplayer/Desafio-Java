package com.bankline.models;

public class Login {
	String cpf;
	String apelido;
	
	public void logar(String cpf, String login) {
		this.cpf = cpf;
		this.apelido = login;
	}
}
