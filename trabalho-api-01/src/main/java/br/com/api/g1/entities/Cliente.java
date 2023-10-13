package br.com.api.g1.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "clientes")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_cliente;	
	private String nome;	
	private String endereco;
	private String telefone;
	private String usuario;
	private String email;
	private String cpf;
	private Date nascimento;
		
	public Cliente() {
		super();
	}

	public Cliente(Integer id_cliente, String nome, String endereco, String telefone, String usuario, String email, String cpf,
			Date nascimento) {
		super();
		this.id_cliente = id_cliente;
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
		this.usuario = usuario;
		this.email = email;
		this.cpf = cpf;
		this.nascimento = nascimento;
	}

	public Integer getId() {
		return id_cliente;
	}

	public void setId(Integer id_cliente) {
		this.id_cliente = id_cliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id_cliente + ", nome=" + nome + ", endereco=" + endereco + ", telefone=" + telefone
				+ ", usuario=" + usuario + ", email=" + email + ", cpf=" + cpf + ", nascimento=" + nascimento + "]";
	}	
	
}
