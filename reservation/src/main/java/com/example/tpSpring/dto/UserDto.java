package com.example.tpSpring.dto;

import java.util.Date;
import java.util.List;

import com.example.tpSpring.model.Reservation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
	
	private String name ; 
	private String type ; 
	private String email ; 
	private String tel ; 	
	private List<Reservation> Reservations ; 

}
