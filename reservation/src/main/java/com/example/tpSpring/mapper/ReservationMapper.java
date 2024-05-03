package com.example.tpSpring.mapper;

import org.springframework.beans.BeanUtils;

import com.example.tpSpring.dto.ReservationDto;
import com.example.tpSpring.model.Reservation;

public class ReservationMapper {

	public ReservationDto toDto(Reservation r) {
		ReservationDto rd = new ReservationDto();
		BeanUtils.copyProperties(r, rd);
		return rd;
	}

	public Reservation toEntity(ReservationDto rd) {
		Reservation r = new Reservation();
		BeanUtils.copyProperties(rd, r);
		return r;

	}

}
