package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.ReplyDAO;
import com.example.domain.ReplyVO;

@RestController
@RequestMapping("/reply")
public class ReplyController {
	
	@Autowired
	ReplyDAO dao;
	
//	@Autowired
	
	
	@PostMapping("/")
	public void insert(@RequestBody ReplyVO vo) {
		
		dao.insert(vo);
		
	}
	
	
	

}
