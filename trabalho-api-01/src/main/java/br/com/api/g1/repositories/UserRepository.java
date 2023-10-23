package br.com.api.g1.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.api.g1.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	@Query(value = "select * from usuario_teste where email_usuario = :email limit 1" , nativeQuery = true)
	Optional<User> findByEmail(String email);

}
