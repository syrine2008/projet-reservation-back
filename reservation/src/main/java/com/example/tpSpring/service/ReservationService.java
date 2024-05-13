package com.example.tpSpring.service;

import java.util.List;

import com.example.tpSpring.dto.ReservationDto;
import com.example.tpSpring.model.Reservation;

public interface ReservationService {
	
	/**
	 * 
	 * @return
	 */
	
	public List<ReservationDto> getAll() ;
	/**
	 * 
	 * @param rd
	 */
	public void createReservation(ReservationDto rd) ;
	
	/**
	 * 
	 * @param rd
	 * @return
	 */
	public ReservationDto modifyReservation(ReservationDto rd) ;
	
	/**
	 * 
	 * @param id
	 */
	public void deleteReservation(int id ) ;
	
	
	/**
	 * 
	 * @param id user
	 * @return
	 */
	public List<ReservationDto> getReservationsbyUserId(int id) ; 
	

	

}
