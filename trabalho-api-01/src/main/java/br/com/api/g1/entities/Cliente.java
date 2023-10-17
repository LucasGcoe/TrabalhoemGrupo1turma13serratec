package br.com.api.g1.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_cliente;	
	private String nome;	
	private String telefone;
	private String usuario;
	private String email;
	private String cpf;
	private Date nascimento;
	private Boolean ativo;
		
	@OneToMany
	@JoinColumn(name = "cliente_id")
	private List<Pedido> pedidos;
			
	public Cliente() {
		super();
	}

	public Cliente(Integer id_cliente, String nome, String telefone, String usuario, String email, String cpf,
			Date nascimento, Boolean ativo) {
		super();
		this.id_cliente = id_cliente;
		this.nome = nome;
		this.telefone = telefone;
		this.usuario = usuario;
		this.email = email;
		this.cpf = cpf;
		this.nascimento = nascimento;
		this.ativo = ativo;
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
	
	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id_cliente + ", nome=" + nome + ", telefone=" + telefone
				+ ", usuario=" + usuario + ", email=" + email + ", cpf=" + cpf + ", nascimento=" + nascimento + ", ativo=" + ativo + "]";
	}	
	
}
