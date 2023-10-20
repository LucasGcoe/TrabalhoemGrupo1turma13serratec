package br.com.api.g1.enums;

public enum TipoRoleEnum {

	ROLE_CLIENTE("CLIENTE"),
	ROLE_FUNCIONARIO("FUNCIONARIO");

	private String tipo;

	TipoRoleEnum(String tipo) {
		this.tipo = tipo;
	}

	public String getTipo() {
		return tipo;
	}
	
}
