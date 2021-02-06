package com.bankline.models;

import java.util.Date;

public abstract class Lancamento {
	Integer conta;
	PlanoConta planoConta;
	String contaDestino;
	Date dataLancamento;
	String descricao;
	Integer valor;
	
	public abstract void registrar();
}
