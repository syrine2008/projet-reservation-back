package com.example.tpSpring.dto;

import java.util.Date;

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
public class UserInscriptionDto {
	
	private int id ; 
	private String name ; 
	private String type ; 
	private String email ; 
	private String tel ; 
	private Date date ; 
	private String login ;
	private String mdp ; 
}
