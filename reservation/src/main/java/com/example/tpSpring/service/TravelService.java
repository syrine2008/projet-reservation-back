package com.example.tpSpring.service;

import java.util.List;

import com.example.tpSpring.dto.FilterTravelDto;
import com.example.tpSpring.dto.TravelDto;
import com.example.tpSpring.dto.UserDto;


public interface TravelService {
	
	/**
	 * 
	 * @param t
	 */
	public void createTravel(TravelDto td);
	/**
	 * 
	 * @return
	 */
	public TravelDto getTravelById(int id );
	
	/**
	 * 
	 * @return
	 */
	public List<TravelDto> getAllTravel(); 
	
	/**
	 * 
	 * @param filters
	 * @return
	 */
	public List<TravelDto> getFiltredTravel(List<FilterTravelDto> filters); 
	
	/**
	 * 
	 * @return
	 */
	public List<String> getAllDestinatioins() ;
	
	/**
	 * 
	 * @param UserDto
	 * @return
	 */
	public List<TravelDto> getTravelByOwnerId(UserDto u) ; 
	
	
	public void deleteTravelByid(int id) ; 
	

}
