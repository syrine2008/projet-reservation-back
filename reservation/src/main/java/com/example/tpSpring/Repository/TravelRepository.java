package com.example.tpSpring.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.tpSpring.model.Travel;
@Repository
public interface TravelRepository extends JpaRepository<Travel, Integer> {

}
