package com.example.tpSpring.model;


import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
@Getter 
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Reservation implements Serializable  {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "reservation_id")
	private int id  ; 
	
    @ManyToOne
    @JoinColumn(name = "user_id")
	private User user ; 
    
    @ManyToOne
    @JoinColumn(name = "travel_id")
	private Travel travel ; 
	
	private Date date ; 
}
