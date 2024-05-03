package com.example.tpSpring.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
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
public class Travel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name = "travel_id")
	private int id;
	private String name;
	private String description;
	private String departure;
	private String destination;
	private String ville;
	private String type;
	private Date startDate;
	private Date endDate;
	private Long price;
	private int nbPlace;
	private boolean disponibility;
	private int note;
	private String commentaire;

	@OneToMany(mappedBy = "travel", cascade = CascadeType.ALL)
	private List<Reservation> reservations;

}
