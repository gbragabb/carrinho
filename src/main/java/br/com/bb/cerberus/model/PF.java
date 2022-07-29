package br.com.bb.cerberus.model;

public class PF extends Cliente{

	private String cpf;
	
	public PF(String nm, String cpf) {
		super(nm);
		this.cpf = cpf;
	}
	
	@Override
	public String toString() {
		return "Nome: "+ super.getNmCLiente() + ", CPF: " + this.cpf;
	}
}
