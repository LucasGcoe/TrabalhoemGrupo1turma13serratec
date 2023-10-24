package br.com.api.g1.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.g1.dto.ClienteDTO;
import br.com.api.g1.entities.Cliente;
import br.com.api.g1.repositories.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	ClienteRepository clienteRepository;

	public Cliente salvarCliente(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	public List<ClienteDTO> listarClientes() {

		List<ClienteDTO> infoClientes = new ArrayList<>();
		List<Cliente> clientes = clienteRepository.findAll();
		for (Cliente cliente : clientes) {
			infoClientes.add(converterClienteDTO(cliente));
		}
		return infoClientes;

	}

	public ClienteDTO converterClienteDTO(Cliente cliente) {
		ClienteDTO clienteConvertido = new ClienteDTO();
		clienteConvertido.setCpf(cliente.getCpf());
		clienteConvertido.setBairro(cliente.getEndereco().getBairro());
		clienteConvertido.setCep(cliente.getEndereco().getCep());
		clienteConvertido.setCpf(cliente.getCpf());
		clienteConvertido.setLocalidade(cliente.getEndereco().getLocalidade());
		clienteConvertido.setLogradouro(cliente.getEndereco().getLogradouro());
		clienteConvertido.setNascimento(cliente.getNascimento());
		clienteConvertido.setTelefone(cliente.getTelefone());
		clienteConvertido.setUf(cliente.getEndereco().getUf());
		clienteConvertido.setUsuario(cliente.getUsuario());
		return clienteConvertido;
	}

	public Cliente listarIdCliente(Integer id) {
		return clienteRepository.findById(id).get();
	}

	public void deletarIdCliente(Integer id) {
		clienteRepository.deleteById(id);
	}

	public void desativarCliente(Integer id) {
		Cliente cliente = listarIdCliente(id);

		if (cliente != null) {
			cliente.setAtivo(false);
			clienteRepository.save(cliente);
		}
	}

	public Cliente atualizarCliente(Integer id, Cliente cliente) {
		Cliente dadoAntigo = listarIdCliente(id);

		if ( dadoAntigo.getCpf() != null) {
			cliente.setCpf( dadoAntigo.getCpf());
		}
		if (dadoAntigo.getUser().getEmail() != null) {
			cliente.getUser().setEmail(dadoAntigo.getUser().getEmail());
		}

		if ( dadoAntigo.getNascimento() != null) {
			cliente.setNascimento(dadoAntigo.getNascimento());
		}
		if ( dadoAntigo.getUser().getNomeUsuario() != null) {
			cliente.getUser().setNomeUsuario(dadoAntigo.getUser().getNomeUsuario());
		}
		if ( dadoAntigo.getTelefone() != null) {
			cliente.setTelefone(dadoAntigo.getTelefone());
		}
		if ( dadoAntigo.getUsuario() != null) {
			cliente.setUsuario(dadoAntigo.getUsuario());
		}
		if (dadoAntigo.getAtivo() != null) {
			cliente.setAtivo(dadoAntigo.getAtivo());
		}

		cliente.setId_cliente(id);
		return clienteRepository.save(cliente);
	}

	public ClienteDTO listarClientesPorCPF(String cpf) {

		Cliente cliente = clienteRepository.findByCpf(cpf);
		return converterClienteDTO(cliente);
	}

}
