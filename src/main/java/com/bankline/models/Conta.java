package com.bankline.models;

public class Conta {
	private String id;//Receberá o login.
	private Double saldo;
	private Lancamento[] lancamentos;
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public Double getSaldo() {
		return saldo;
	}
	
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	
	public Lancamento[] getLancamentos() {
		return lancamentos;
	}
	
	public void setLancamentos(Lancamento[] lancamentos) {
		this.lancamentos = lancamentos;
	}
	
	
}
