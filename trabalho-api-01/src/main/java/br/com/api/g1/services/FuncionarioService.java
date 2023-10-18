package br.com.api.g1.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.api.g1.entities.Funcionario;
import br.com.api.g1.repositories.FuncionarioRepository;

@Service
public class FuncionarioService {
	
	@Autowired
	FuncionarioRepository funcionarioRepository; 

	public Funcionario salvarFuncionario(Funcionario funcionario) {
		return funcionarioRepository.save(funcionario);
		}
	
	public List<Funcionario> listarFuncionarios(){
			return funcionarioRepository.findAll();
	
	}
	
	public Funcionario listarIdFuncionario(Integer id) {
		return funcionarioRepository.findById(id).get();
	}
	public void deletarIdFuncionario(@PathVariable Integer id) {
		funcionarioRepository.deleteById(id);
	}	
	
	public void desativarFuncionario(Integer id) {
		Funcionario funcionario = listarIdFuncionario(id);
		
		if(funcionario != null) {
			funcionario.setAtivo(false);
			funcionarioRepository.save(funcionario);
		}
	}

	public Funcionario atualizarFuncionario(Integer id, Funcionario funcionario) {
		Funcionario dadoAntigo = listarIdFuncionario(id);
		
		if(funcionario.getAtivo()!=null) {
			dadoAntigo.setAtivo(funcionario.getAtivo());
		}
		if(funcionario.getCpf() != null) {
			dadoAntigo.setCpf(funcionario.getCpf());
		}
		if(funcionario.getNomeUsuario() != null) {
			dadoAntigo.setNomeUsuario(funcionario.getNomeUsuario());
		}
		dadoAntigo.setId_funcionario(id);
		return funcionarioRepository.save(dadoAntigo);
	}
 }
