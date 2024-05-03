package com.example.tpSpring.mapper;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.example.tpSpring.dto.UserDto;

import com.example.tpSpring.model.User;

@Component
public class UserMapper {

	public UserDto toDto(User u) {
		UserDto ud = new UserDto();
		BeanUtils.copyProperties(u, ud);
		return ud;
	}

	public User toEntity(UserDto ud) {
		User u = new User();
		BeanUtils.copyProperties(ud, u);
		return u;

	}

}
