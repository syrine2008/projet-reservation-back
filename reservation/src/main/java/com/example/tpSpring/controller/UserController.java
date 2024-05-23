package com.example.tpSpring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.tpSpring.dto.EntityResponse;
import com.example.tpSpring.dto.UserDto;
import com.example.tpSpring.dto.UserInscriptionDto;
import com.example.tpSpring.model.User;
import com.example.tpSpring.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	/**
	 * 
	 * @return la liste de tous les utilisateurs
	 */
	@GetMapping("/")
	public List<UserDto> getAll() {

		return userService.getAllUsers();

	}

	/***
	 * 
	 * @param userDto
	 * @return
	 */
	@PostMapping("/create")
	public EntityResponse<String> createUser(@RequestBody UserInscriptionDto udi) {
		
			return userService.createUser(udi);
	

	}

	/**
	 * 
	 * @param int id
	 * @return
	 */
	@GetMapping("/user")
	public UserDto getUserById(@RequestParam("id") int id) {

		return userService.getUserById(id);

	}

	/**
	 * 
	 * @param userDto 
	 * @return
	 */
	@PutMapping("/modify")
	public UserDto modifierUser(@RequestBody UserDto ud) {

		return userService.modifyUser(ud);

	}

	
	/**
	 * 
	 * @param id
	 */
	@GetMapping("/delete")
	public void deleteUser(@RequestParam("id") int id) {

		userService.deleteUser(id);

	}
	
	
	@GetMapping("/connexion")
	public Optional<User> connexion(@RequestParam("login") String login ,@RequestParam("mdp") String mdp) {
		
		return userService.getConnexion(login, mdp) ;
	}

}
