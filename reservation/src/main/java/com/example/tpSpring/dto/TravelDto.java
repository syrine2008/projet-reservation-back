package com.example.tpSpring.dto;

import java.util.Date;
import java.util.List;

import com.example.tpSpring.model.Reservation;
import com.example.tpSpring.model.Travel;
import com.example.tpSpring.model.User;

import jakarta.persistence.Entity;
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
public class TravelDto {

	private int id ; 
	private String name ; 
	private String description ; 
	private String departure ; 
	private String destination ; 
	private String ville ; 
	private String type ; 
	private Date startDate ; 
	private Date endDate ; 
	private Long price ; 
	private int nbPlace ; 
	private String disponibility ;
	private int note ; 
	private String commentaire ; 
	private String urlImage ;
	private User owner;
	
}
