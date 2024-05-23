package com.example.tpSpring.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.tpSpring.model.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	
	@Query(value ="select u from User u where u.login = ?1 and u.mdp = ?2")
	public Optional<User> connexion(String login, String mdp) ; 
	
	@Query(value = "select u from User u where u.login = ?1")
	public Optional<User> getUserByLogin(String login) ;

}
