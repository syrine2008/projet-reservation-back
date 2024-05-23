package com.example.tpSpring.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
public class Travel{


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
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
	private String disponibility;
	private String urlImage ;
	
    @OneToMany(mappedBy = "travel")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
	private List<Commentaire> commentaires;
	
	@ManyToOne
	@JoinColumn(name = "owner")
	private User owner;



}
