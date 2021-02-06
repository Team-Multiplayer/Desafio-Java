package com.bankline.models;

import java.util.Date;

public abstract class Lancamento {
	private Integer conta;
	private PlanoConta planoConta;
	private String contaDestino;
	private Date dataLancamento;
	private String descricao;
	private Integer valor;
	
	public abstract void registrar();

	public Integer getConta() {
		return conta;
	}

	public void setConta(Integer conta) {
		this.conta = conta;
	}

	public PlanoConta getPlanoConta() {
		return planoConta;
	}

	public void setPlanoConta(PlanoConta planoConta) {
		this.planoConta = planoConta;
	}

	public String getContaDestino() {
		return contaDestino;
	}

	public void setContaDestino(String contaDestino) {
		this.contaDestino = contaDestino;
	}

	public Date getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(Date dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getValor() {
		return valor;
	}

	public void setValor(Integer valor) {
		this.valor = valor;
	}
	
	
}
