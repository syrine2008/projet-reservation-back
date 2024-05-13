package com.example.tpSpring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tpSpring.dto.FilterTravelDto;
import com.example.tpSpring.dto.TravelDto;
import com.example.tpSpring.service.TravelService;

@RestController
@RequestMapping("/travel")
public class TravelController {

	@Autowired
	private TravelService travelService;

	@GetMapping("/")
	public List<TravelDto> getAll() {

		return travelService.getAllTravel();

	}

	@PostMapping("/create")
	public TravelDto createUser(@RequestBody TravelDto td) {
		try {
			travelService.createTravel(td);
			return td;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}

	}

	@GetMapping("/filtredTravel")
	public List<TravelDto> getFiltredTrqvel(@RequestBody List<FilterTravelDto> l) {

		return travelService.getFiltredTravel(l);

	}

}
