package com.example.tpSpring.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tpSpring.Repository.CommentaireRepository;
import com.example.tpSpring.dto.CommentaireDto;
import com.example.tpSpring.mapper.CommentaireMapping;
import com.example.tpSpring.service.CommantaireService;

@Service
public class CommantaireServiceImp implements CommantaireService{
	
	
	
	@Autowired
	private CommentaireRepository commentaireRepository ;
	
	@Autowired
	private CommentaireMapping commentaireMapping ;

	@Override
	public void createCommantaire(CommentaireDto cd) {
		
		this.commentaireRepository.save(this.commentaireMapping.toEntity(cd)) ;
		
		
	}

}
