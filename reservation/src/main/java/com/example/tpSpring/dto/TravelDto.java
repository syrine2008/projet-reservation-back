package com.example.tpSpring.dto;

import java.util.Date;
import java.util.List;

import com.example.tpSpring.model.Reservation;
import com.example.tpSpring.model.Travel;

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
	private boolean disponibility ;
	private int note ; 
	private String commentaire ; 
	
}
