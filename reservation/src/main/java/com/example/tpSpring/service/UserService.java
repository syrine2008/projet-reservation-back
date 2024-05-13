package com.example.tpSpring.service;

import java.util.List;

import com.example.tpSpring.dto.UserDto;


public interface UserService {
	/**
	 * 
	 * @param id
	 * @return
	 */
	public UserDto getUserById(int id); 
	
	/**
	 * 
	 * @param userDto
	 */	
	public void createUser(UserDto ud);
	
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
	

}
