package com.example.tpSpring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tpSpring.dto.ReservationDto;
import com.example.tpSpring.service.ReservationService;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

	
	@Autowired
	private ReservationService reservationService;
	
	
	@GetMapping("/")
	public List<ReservationDto> getAll(){
		return reservationService.getAll();
	}
	
	@PostMapping("/create")
	public ReservationDto createReservation(@RequestBody ReservationDto rd ) {
		try {
			reservationService.createReservation(rd);
			return rd ; 
		} catch (Exception e) {
			return null ; 
		}
	}
	
	
}
