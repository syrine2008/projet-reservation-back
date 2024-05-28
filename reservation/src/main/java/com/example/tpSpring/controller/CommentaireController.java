package com.example.tpSpring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tpSpring.dto.CommentaireDto;
import com.example.tpSpring.service.CommantaireService;

@RestController
@RequestMapping("/commentaire")
public class CommentaireController {
	
	
	@Autowired
	private CommantaireService commantaireService ; 
	
	@PostMapping("/addCommentaire")
	public void addCommantaire(@RequestBody  CommentaireDto  commentaire) {
		
		this.commantaireService.createCommantaire(commentaire) ; 
		
	}

}
