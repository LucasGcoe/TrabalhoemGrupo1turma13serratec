package br.com.api.g1.entities;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "funcionario")
public class Funcionario{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_funcionario")
	private Integer id_funcionario;
	@Column(name = "cpf_funcionario")
	@NotNull 
	@Size(max=11)
	private String	cpf;
	@Column(name = "ativo")
	private Boolean ativo;
	
	@OneToMany
	@JoinColumn(name = "funcionario_id")
	private List<Produto> produtos;
	
	@OneToOne
	@JoinColumn(name = "user_id")
	private User user;

	public Funcionario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Funcionario(Integer id_funcionario, @NotNull @Size(max = 11) String cpf, Boolean ativo,
			List<Produto> produtos, User user) {
		super();
		this.id_funcionario = id_funcionario;
		this.cpf = cpf;
		this.ativo = ativo;
		this.produtos = produtos;
		this.user = user;
	}

	public Integer getId_funcionario() {
		return id_funcionario;
	}

	public void setId_funcionario(Integer id_funcionario) {
		this.id_funcionario = id_funcionario;
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

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Funcionario [id_funcionario=" + id_funcionario + ", cpf=" + cpf + ", ativo=" + ativo + ", produtos="
				+ produtos + ", user=" + user + "]";
	}
	
	
}

