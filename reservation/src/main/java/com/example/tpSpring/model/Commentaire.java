package com.example.tpSpring.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Entity
@Getter 
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Commentaire {
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name = "id")
	private int id ; 
    @ManyToOne
    @JoinColumn(name = "idtravel")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonIgnore
	private Travel travel ;
	@ManyToOne
    @JoinColumn(name = "iduser")
	private User user ; 
	private String commentaire ;
	private Date date  ;
	private int note ; 

}
