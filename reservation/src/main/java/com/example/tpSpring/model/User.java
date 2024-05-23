package com.example.tpSpring.model;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
public class User {
	

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id ; 
	private String name ; 
	private String type ; 
	private String email ; 
	private String tel ; 
	private Date date ; 
	@JsonIgnore
	private String login ;
	@JsonIgnore
	private String mdp ; 
	
	
//	@OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
//	private List<Travel> travels ; 
	
//	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
//	private List<Reservation> Reservations ; 
	

}
