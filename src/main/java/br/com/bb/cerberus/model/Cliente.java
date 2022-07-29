package br.com.bb.cerberus.model;

public abstract class Cliente {

	private String nmCLiente;
	
	public Cliente(String nm) {
		this.nmCLiente = nm; 
	}

	public String getNmCLiente() {
		return nmCLiente;
	}

	public void setNmCLiente(String nmCLiente) {
		this.nmCLiente = nmCLiente;
	}
}
