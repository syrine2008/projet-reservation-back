package com.example.tpSpring.mapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.example.tpSpring.dto.TravelDto;
import com.example.tpSpring.model.Travel;


@Component
public class TravelMapper {
	
	
	
	
	public TravelDto toDto(Travel v) {
		TravelDto vd = new TravelDto() ;
		BeanUtils.copyProperties(v, vd);		
		return vd ; 
	}
	
	
	public Travel toEntity(TravelDto vd) {
		Travel v = new Travel(); 
		BeanUtils.copyProperties(vd, v);
		return v; 

	}
	

}
