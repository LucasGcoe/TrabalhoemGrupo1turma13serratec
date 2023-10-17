package br.com.api.g1.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "endereco")

public class Endereco {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_endereco;
	private String cep;
	private String logradouro;
	private String bairro;
	private String localidade;
	private String uf;
	
	//@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	@OneToMany
	@JoinColumn(name = "endereco")
	private List<Cliente> clientes;
	
	public Endereco() {
		super();
	}

	public Endereco(String cep, String logradouro, String bairro, String localidade, String uf) {
		super();
		this.cep = cep;
		this.logradouro = logradouro;
		this.bairro = bairro;
		this.localidade = localidade;
		this.uf = uf;
	}	
	
	public Integer getId_endereco() {
		return id_endereco;
	}

	public void setId_endereco(Integer id_endereco) {
		this.id_endereco = id_endereco;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getLocalidade() {
		return localidade;
	}

	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	@Override
	public String toString() {
		return "Endereco [cep=" + cep + ", logradouro=" + logradouro + ", bairro=" + bairro + ", localidade="
				+ localidade + ", uf=" + uf + "]";
	}

}