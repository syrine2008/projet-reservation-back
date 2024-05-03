package com.example.tpSpring.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.tpSpring.model.Reservation;


@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer>{

}
