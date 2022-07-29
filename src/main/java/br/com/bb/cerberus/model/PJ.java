package br.com.bb.cerberus.model;

public class PJ extends Cliente {

	private String cnpj;

	public PJ(String nm, String cnpj) {
		super(nm);
		this.setCnpj(cnpj);
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	@Override
	public String toString() {
		return "Raz�o Social: "+ super.getNmCLiente() + ", CNPJ: " + this.cnpj;
	}
}
