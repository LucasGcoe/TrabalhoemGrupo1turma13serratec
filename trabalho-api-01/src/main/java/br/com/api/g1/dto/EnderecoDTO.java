package br.com.api.g1.dto;

public class EnderecoDTO {

	private String cep;	

	public EnderecoDTO() {
		super();
	}

	public EnderecoDTO(String cep) {
		super();
		this.cep = cep;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

}
