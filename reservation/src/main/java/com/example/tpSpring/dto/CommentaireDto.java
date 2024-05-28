package com.example.tpSpring.dto;

import java.util.Date;

import com.example.tpSpring.model.Travel;
import com.example.tpSpring.model.User;

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
public class CommentaireDto {

	
	private int id ;    
	private Travel travel ;
	private User user ; 
	private String commentaire ;
	private Date date  ;
	private int note ; 

	
}
