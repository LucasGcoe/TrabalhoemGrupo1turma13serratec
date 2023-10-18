package br.com.api.g1.entities;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente extends User{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_cliente;		
	private String telefone;
	private String usuario;
	private String cpf;
	private Date nascimento;
	private Boolean ativo;
		
	@OneToMany
	@JoinColumn(name = "cliente_id")
	private List<Pedido> pedidos;
			
	@OneToOne
	@JoinColumn(name = "user_id")
	private User user;

	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cliente(Integer idUser, String nomeUsuario, String email, Set<Role> roles, String password) {
		super(idUser, nomeUsuario, email, roles, password);
		// TODO Auto-generated constructor stub
	}

	public Cliente(Integer id_cliente, String telefone, String usuario, String cpf, Date nascimento, Boolean ativo,
			List<Pedido> pedidos, User user) {
		super();
		this.id_cliente = id_cliente;
		this.telefone = telefone;
		this.usuario = usuario;
		this.cpf = cpf;
		this.nascimento = nascimento;
		this.ativo = ativo;
		this.pedidos = pedidos;
		this.user = user;
	}

	public Integer getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(Integer id_cliente) {
		this.id_cliente = id_cliente;
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

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Cliente [id_cliente=" + id_cliente + ", telefone=" + telefone + ", usuario=" + usuario + ", cpf=" + cpf
				+ ", nascimento=" + nascimento + ", ativo=" + ativo + ", pedidos=" + pedidos + ", user=" + user + "]";
	}
	
	
}
