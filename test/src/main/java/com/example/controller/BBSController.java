package com.example.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.BBSDAO;
import com.example.domain.BBSVO;
import com.example.domain.QueryVO;

@RestController
@RequestMapping("/bbs")
public class BBSController {
	
	@Autowired
	BBSDAO dao;
	
	@GetMapping("/list")
	public HashMap<String,Object> list(QueryVO vo){
		System.out.println(vo);
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("total", dao.total());
		map.put("list", dao.list(vo));
		return map;
	}
	@GetMapping("/{bid}")
	public BBSVO read(@PathVariable("bid") int bid) {
		return dao.read(bid);
	}
	@PostMapping("/")
	public void insert(@RequestBody BBSVO vo) {
		dao.insert(vo);
	}
	@DeleteMapping("/{bid}")
	public void delete(@PathVariable("bid")int bid) {
		dao.delete(bid);
	}
	@PutMapping("/")
	public void update(@RequestBody BBSVO vo) {
		System.out.println(vo);
		dao.update(vo);
	}
	@PatchMapping("/{bid}")
	public void updateTitle(@PathVariable("bid")int bid,@RequestBody String title) {
		BBSVO vo= dao.read(bid);
		vo.setTitle(title);
	}
	
	
}
