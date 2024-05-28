package com.example.tpSpring.mapper;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.example.tpSpring.dto.CommentaireDto;
import com.example.tpSpring.model.Commentaire;
@Component
public class CommentaireMapping {
	
	public CommentaireDto toDto(Commentaire c) {
		CommentaireDto cd = new CommentaireDto();
		BeanUtils.copyProperties(c, cd);
		return cd;
	}

	public Commentaire toEntity(CommentaireDto cd) {
		Commentaire c = new Commentaire();
		BeanUtils.copyProperties(cd, c);
		return c;

	}

}
