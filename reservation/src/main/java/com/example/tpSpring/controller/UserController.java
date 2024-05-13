package com.example.tpSpring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.tpSpring.dto.UserDto;
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
	public UserDto createUser(@RequestBody UserDto ud) {
		try {
			userService.createUser(ud);
			return ud;
		} catch (Exception e) {
			return null;
		}

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

}
