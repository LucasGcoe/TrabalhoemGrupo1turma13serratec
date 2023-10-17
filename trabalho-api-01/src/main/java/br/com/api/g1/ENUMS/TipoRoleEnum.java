package br.com.api.g1.ENUMS;

public enum TipoRoleEnum {

	ROLE_USER("USUARIO"),
	ROLE_ADMIN("ADMINISTRADOR");

	private String tipo;

	TipoRoleEnum(String tipo) {
		this.tipo = tipo;
	}

	public String getTipo() {
		return tipo;
	}
	
}
