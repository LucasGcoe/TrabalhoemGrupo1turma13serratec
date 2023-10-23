package br.com.api.g1.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.api.g1.dto.ClienteDTO;
import br.com.api.g1.entities.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
	List<Cliente> findByCpf(String cpf);
	//@Query(value = "select * from cliente where cpf_cliente  = :cpf", nativeQuery = true)
	
	//public ClienteDTO listarClientePorCPF(String cpf);
	
}

