package com.example.tpSpring.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.tpSpring.model.Commentaire;

@Repository
public interface CommentaireRepository extends JpaRepository<Commentaire, Integer>{

	@Query(value = "SELECT SUM(c.note) FROM Commentaire c WHERE c.travel.id = ?1")
	public Optional<Integer> calCalculSommesDesNotes(int id) ; 
	
	@Query(value = "SELECT c FROM Commentaire c WHERE c.travel.id = ?1")
	public Optional<List<Commentaire>> getCommantaireByTravelId(int id) ; 
	
	
	
}
