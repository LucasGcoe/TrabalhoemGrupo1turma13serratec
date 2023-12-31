package br.com.api.g1.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.g1.entities.User;
import br.com.api.g1.repositories.UserRepository;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User findByEmail(String email){
        return userRepository.findByEmail(email).get();
    }
    
//    public User findByCpf(String cpf){
//        return userRepository.findByCpf(cpf);
//    }

    public User save(User user){
        return userRepository.save(user);
    }

	public List<User> listarTodos() {
		return userRepository.findAll();
	}
	
}
