package br.com.api.g1.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.api.g1.entities.Cliente;
import br.com.api.g1.repositories.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	ClienteRepository clienteRepository;
	
	public Cliente salvarCliente(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	public List<Cliente> listarClientes(){
		return clienteRepository.findAll();
	}
	
	public Cliente listarIdCliente(Integer id) {
		return clienteRepository.findById(id).get();
	}
	
	public void deletarIdCliente(@PathVariable Integer id) {
		clienteRepository.deleteById(id);
	}
	
	public void desativarCliente(Integer id) {
		Cliente cliente = listarIdCliente(id);
		
		if(cliente != null) {
			cliente.setAtivo(false);
			clienteRepository.save(cliente);
		}
	}
	
	public Cliente atualizarCliente(Integer id, Cliente cliente) {
		Cliente dadoAntigo = listarIdCliente(id);
		
		if(cliente.getCpf() != null) {
			dadoAntigo.setCpf(cliente.getCpf());
		}
		if(cliente.getEmail() != null) {
			dadoAntigo.setEmail(cliente.getEmail());
		}
		if(cliente.getEndereco() != null) {
			dadoAntigo.setEndereco(cliente.getEndereco());
		}
		if(cliente.getNascimento() != null) {
			dadoAntigo.setNascimento(cliente.getNascimento());
		}
		if(cliente.getNome() != null) {
			dadoAntigo.setNome(cliente.getNome());
		}
		if(cliente.getTelefone() != null) {
			dadoAntigo.setTelefone(cliente.getTelefone());
		}
		if(cliente.getUsuario() != null) {
			dadoAntigo.setUsuario(cliente.getUsuario());
		}
		if(cliente.getAtivo() != null) {
			dadoAntigo.setAtivo(cliente.getAtivo());
		}
		
		dadoAntigo.setId(id);
		return clienteRepository.save(dadoAntigo);
	}
	
	
}















