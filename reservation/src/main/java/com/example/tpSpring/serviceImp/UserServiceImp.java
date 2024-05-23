package com.example.tpSpring.serviceImp;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tpSpring.Repository.UserRepository;
import com.example.tpSpring.dto.EntityResponse;
import com.example.tpSpring.dto.UserDto;
import com.example.tpSpring.dto.UserInscriptionDto;
import com.example.tpSpring.mapper.UserMapper;
import com.example.tpSpring.model.User;
import com.example.tpSpring.service.UserService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
class UserServiceImp implements UserService {

	@Autowired
	private UserRepository userRepository;

	/**
	 * permets de convertir entity to model ou model to entity
	 */
	@Autowired
	private UserMapper userMapper;

	@Override
	public UserDto getUserById(int id) {
		Optional<User> optionaluser = userRepository.findById(id);
		if (optionaluser.isPresent()) {

			return userMapper.toDto(  optionaluser.get());
		} else {
			return null;
		}
	}

	@Override
	public EntityResponse<String> createUser(UserInscriptionDto udi) {
		Optional<User> userOptional = userRepository.getUserByLogin(udi.getLogin()); 
		if(userOptional.isPresent()) {
			return new EntityResponse<>(false, "l'utilisateur existe deja ", "");
		}else {
			userRepository.save(userMapper.insciptioToEntity(udi)) ; 
			return new EntityResponse<>(true, "user created ", "succes");	
		}
		


	}
	
	

	@Override
	public UserDto modifyUser(UserDto ud) {

		Optional<User> optionaluser = userRepository.findById(ud.getId());

		if (optionaluser.isPresent()) {
			User u = optionaluser.get();
			u = userMapper.toEntity(ud);
			userRepository.save(u);
			return ud;
		} else {
			return null;
		}

	}

	@Override
	public void deleteUser(int id) {

		userRepository.deleteById(id);
	}

	@Override
	public List<UserDto> getAllUsers() {

		return userRepository.findAll().stream().map(user -> userMapper.toDto(user)).collect(Collectors.toList());
	}

	@Override
	public Optional<User> getConnexion(String login, String mdp) {
		Optional<User> user = userRepository.connexion(login,mdp)  ;
		if(user.isPresent()) {
			return user ; 
		}else {
			return null ;
		}
		
	}

}
