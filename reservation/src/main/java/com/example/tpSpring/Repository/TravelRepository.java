package com.example.tpSpring.Repository;

import java.util.List;

import org.springframework.data.annotation.QueryAnnotation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.tpSpring.model.Travel;
import com.example.tpSpring.model.User;
@Repository
public interface TravelRepository extends JpaRepository<Travel, Integer> {
	
	
	@Query(value = "SELECT DISTINCT(t.destination) FROM Travel t")
	List<String> getAllDestinations();
	
	
	
	@Query(value = "SELECT t FROM Travel t where t.owner = ?1 ")
	List<Travel> getTravelByOwnerId(User u) ; 
	
	
	
	
}
