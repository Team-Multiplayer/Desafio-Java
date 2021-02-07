package com.bankline.models;

import java.util.Date;

public class Lancamento {
	
	private Conta conta;
	private Date dataLancamento;
	private String descricao;
	private Double valor;
	private PlanoConta tipo; // tipo de lançamento
	private Conta contaDestino;
	
}
