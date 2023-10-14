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
@Table(name = "funcionario")
public class Funcionario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_funcionario;
	private String	nome;
	private String	cpf;
	private Boolean ativo;
	
	@OneToMany
	@JoinColumn(name = "funcionario_id")
	private List<Produto> produtos;
	
	public Funcionario() {
		super();
	}

	public Funcionario(Integer id_funcionario, String nome, String cpf, Boolean ativo) {
		super();
		this.id_funcionario = id_funcionario;
		this.nome = nome;
		this.cpf = cpf;
		this.ativo = ativo;
	}

	public Integer getId_funcionario() {
		return id_funcionario;
	}

	public void setId_funcionario(Integer id_funcionario) {
		this.id_funcionario = id_funcionario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	@Override
	public String toString() {
		return "Funcionario [id_funcionario=" + id_funcionario + ", nome=" + nome + ", cpf=" + cpf + ", ativo=" + ativo
				+ "]";
	}

	
	
	
	
}
