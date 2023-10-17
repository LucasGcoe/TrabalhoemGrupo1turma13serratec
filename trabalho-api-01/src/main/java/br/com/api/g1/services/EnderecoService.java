package br.com.api.g1.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.api.g1.dto.EnderecoDTO;
import br.com.api.g1.entities.Endereco;
import br.com.api.g1.repositories.EnderecoRepository;

@Service
public class EnderecoService {

	@Autowired
	EnderecoRepository enderecoRepository;

	public Endereco pesquisarEndereco(String cep) {
		RestTemplate restTemplate = new RestTemplate();
		String uri = "http://viacep.com.br/ws/{cep}/json/";
		Map<String, String> params = new HashMap<>();
		params.put("cep", cep);
		return restTemplate.getForObject(uri, Endereco.class, params);
	}

	public Endereco salvarEndereco(EnderecoDTO endereco) {
		Endereco viaCep = pesquisarEndereco(endereco.getCep());
		Endereco enderecoNovo = new Endereco();
		enderecoNovo.setBairro(viaCep.getBairro());
		enderecoNovo.setCep(endereco.getCep());
		enderecoNovo.setLocalidade(viaCep.getLocalidade());
		enderecoNovo.setLogradouro(viaCep.getLogradouro());
		enderecoNovo.setUf(viaCep.getUf());
		return enderecoRepository.save(enderecoNovo);
	}

}
