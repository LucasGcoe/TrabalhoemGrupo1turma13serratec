package br.com.api.g1.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "funcionario")
public class Funcionario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_funcionario;
	private String	nome;
	private String	cpf;
	
	
	
	public Funcionario() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Funcionario(Integer id_funcionario, String nome, String cpf) {
		super();
		this.id_funcionario = id_funcionario;
		this.nome = nome;
		this.cpf = cpf;
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


	@Override
	public String toString() {
		return "Funcionario [id_funcionario=" + id_funcionario + ", nome=" + nome + ", cpf=" + cpf + "]";
	}
	
}
