package com.example.tpSpring.mapper;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.tpSpring.Repository.CommentaireRepository;
import com.example.tpSpring.Repository.TravelRepository;
import com.example.tpSpring.dto.TravelDto;
import com.example.tpSpring.model.Travel;


@Component
public class TravelMapper {
	
	@Autowired
	private CommentaireRepository commentaireRepository;
	
	
	public TravelDto toDto(Travel v) {
		TravelDto vd = new TravelDto() ;
		BeanUtils.copyProperties(v, vd);
		Optional<Integer> note = commentaireRepository.calCalculSommesDesNotes(v.getId()) ;
		if(note.isPresent()) {
			vd.setNote(note.get());
		}
		
		
		return vd ; 
	}
	
	
	public Travel toEntity(TravelDto vd) {
		Travel v = new Travel(); 
		BeanUtils.copyProperties(vd, v);
		return v; 

	}
	

}
