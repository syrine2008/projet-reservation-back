package com.example.tpSpring.serviceImp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tpSpring.Repository.ReservationRepository;
import com.example.tpSpring.Repository.UserRepository;
import com.example.tpSpring.dto.ReservationDto;
import com.example.tpSpring.mapper.ReservationMapper;
import com.example.tpSpring.model.Reservation;
import com.example.tpSpring.service.ReservationService;

@Service
public class ReservationServiceImp implements ReservationService{

	
	@Autowired
	private ReservationRepository reservationRepository ;
	
	@Autowired
	private ReservationMapper rservationMapper ;
	
	@Override
	public List<ReservationDto> getAll() {
		
		return  reservationRepository.findAll()
				.stream()
				.map(resrvation -> rservationMapper.toDto(resrvation))
				.collect(Collectors.toList());
	}

	@Override
	public List<ReservationDto> getReservationsbyUserId(int id) {
	
		
		
		return reservationRepository.getReservationByUserId(id)
		.stream()
		.map(resrvation ->  rservationMapper.toDto(resrvation))
		.collect(Collectors.toList()) ; 
		
		
	}

	@Override
	public void createReservation(ReservationDto rd) {
		reservationRepository.save(rservationMapper.toEntity(rd));
	}

	@Override
	public ReservationDto modifyReservation(ReservationDto rd) {
	Optional<Reservation> optionalReservation = reservationRepository.findById(rd.getId());
	
	if(optionalReservation.isPresent()) {
		Reservation r = optionalReservation.get() ; 
		r = rservationMapper.toEntity(rd);
		reservationRepository.save(r); 
		return rd ; 
		
	}else {
		return null;
	}
	
	}

	@Override
	public void deleteReservation(int id) {
		reservationRepository.deleteById(id);
		
	}

}
