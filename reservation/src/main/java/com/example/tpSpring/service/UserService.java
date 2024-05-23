package com.example.tpSpring.service;

import java.util.List;
import java.util.Optional;

import com.example.tpSpring.dto.EntityResponse;
import com.example.tpSpring.dto.UserDto;
import com.example.tpSpring.dto.UserInscriptionDto;
import com.example.tpSpring.model.User;


public interface UserService {
	/**
	 * 
	 * @param id
	 * @return
	 */
	public UserDto getUserById(int id); 
	
	/**
	 * 
	 * @param userDto inscription
	 * @return 
	 */	
	public EntityResponse<String> createUser(UserInscriptionDto udi);
	
	/**
	 * 
	 * @param userDto
	 * @return
	 */
	public UserDto modifyUser(UserDto ud); 
	
	/**
	 * 
	 * @param userDto
	 */
	public void deleteUser(int id ) ;
	
	/**
	 * *
	 * @return
	 */
	public List<UserDto> getAllUsers() ;
	/**
	 * 
	 * @param login
	 * @param mdp
	 * @return
	 */
	public Optional<User> getConnexion(String login , String mdp);

	
}
